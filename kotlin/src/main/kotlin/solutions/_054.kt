package solutions

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.math.pow

/**
 * After representing cards by a class and implementing the functions that allow finding the type of hand, I gave
 * each hand a score such as that the weight of the type is largest followed by the card the rank is made of.
 *
 * That way a superior rank will always beat any inferior rank whatever the cards may be. (eg: 3 2s vs 2 Aces).
 * While providing a way to differentiate between same ranks but different cards.
 *
 * If the scores are the same I calculate a value for the cards in base-13.. where 2 -> 0 and A -> 12 by ordering the
 * cards in descending order: eg K Q T 8 2 -> K*13^4 + Q*13^3 + T*13^2 + 8*13^1 + 2*13^0 = 337571
 * I then use this number to determine the highest card to break ties, there are better ways to do this.
 */

fun pokerHands(): Int {
    var count = 0
    Files.lines(Paths.get("../res/054_poker.txt")).forEach {
        val cards = it.split(" ")
        val i = cards.take(5).map { c -> Card(c) }.toTypedArray()
        val ii = cards.takeLast(5).map { c -> Card(c) }.toTypedArray()

        val w = i.value() - ii.value()
        val r = if(w != 0) w else i.toDodeca() - ii.toDodeca()
        if(r > 0) count++
    }
    return count
}

private data class Card(val n: Int, val suit: Char) {
    constructor(card: String) : this(if(card[0].isDigit()) card[0].toString().toInt() else {
        when(card[0]) {
            'T' -> 10
            'J' -> 11
            'Q' -> 12
            'K' -> 13
            'A' -> 14
            else -> throw IllegalStateException()
        }
    }, card[1])
}

private fun Array<Card>.value(): Int {
    val ss = isSameSuit()
    val iv = isNoaK(4)
    val iii = isNoaK(3)
    val ii = isNoaK(2)
    val iip = isTwoPairs()
    val m = maxBy { it.n }.n
    return when {
        ss && contains(10, 11, 12, 13, 14) -> 51200
        ss && isAscending() -> 25600 + 10*m
        iv != 0 -> 12800 + 10*iv
        iii*ii != 0 -> 6400 + 100*iii + 10*ii
        ss -> 3200 + 10*m
        isAscending() -> 1600 + 10*m
        iii != 0 -> 800 + 10*iii
        iip != 0 -> 400 + 10*iip
        ii != 0 -> 200 + 10*ii
        else -> m
    }
}

private fun Array<Card>.contains(vararg n: Int) = n.any { i -> any { it.n == i } }
private fun Array<Card>.isNoaK(c: Int) = (2..14).firstOrNull { n -> count { it.n == n } == c } ?: 0
private fun Array<Card>.isSameSuit() = none { it.suit != this[0].suit }
private fun Array<Card>.toDodeca() = sortedBy { it.n }.mapIndexed { i, card -> (card.n - 2)*13.0.pow(i.toDouble()) }.sum().toInt()
private fun Array<Card>.isTwoPairs(): Int {
    val pairs = (2..14).filter { n -> count { it.n == n } == 2 }
    return if(pairs.count() == 2) pairs.last() else 0
}
private fun Array<Card>.isAscending(): Boolean {
    val c = sortedBy { it.n }
    val f = c.first()
    return c.filterIndexed { i, j -> j.n != f.n + i }.none()
}
