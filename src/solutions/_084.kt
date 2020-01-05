package solutions

import kotlin.random.Random

/**
 * Simulated a million-turn long game of Monopoly, while tracking the square frequencies in an array.
 *
 * 'p' is the current position.
 * 'cc' is the current community chest card.
 * 'ch' is the current chance card.
 * 'db' tracks the number of consecutive doubles.
 */

fun monopolyOdds(): String {
    var p = 0
    var cc = 0
    var ch = 0
    var db = 0
    val d = 4
    val f = IntArray(40)
    val nextRail = { x: Int ->
        when {
            x < 5 -> 5
            x < 15 -> 15
            x < 25 -> 25
            x < 35 -> 35
            else -> 5
        }
    }
    val nextUtility = { x: Int ->
        when {
            x < 12 -> 12
            x < 28 -> 28
            else -> 12
        }
    }
    repeat(1_000_000) {
        val r1 = Random.nextInt(d) + 1
        val r2 = Random.nextInt(d) + 1
        if(r1 == r2) {
            db++
        } else {
            db = 0
        }
        p += r1 + r2
        p %= 40
        if(db == 3) {
            db = 0
            p = 10
        } else when(p) {
            2, 17, 33 -> {
                when(cc) {
                    0 -> p = 0
                    1 -> p = 10
                }
                cc++
                cc %= 16
            }
            7, 22, 36 -> {
                when(ch) {
                    0 -> p = 0
                    1 -> p = 10
                    2 -> p = 11
                    3 -> p = 24
                    4 -> p = 39
                    5 -> p = 5
                    6, 7 -> p = nextRail(p)
                    8 -> p = nextUtility(p)
                    9 -> p -= 3
                }
                ch++
                ch %= 16
            }
            30 -> p = 10
        }
        f[p]++
    }
    val s = f.sortedArrayDescending()
    return "${f.indexOf(s[0])}${f.indexOf(s[1])}${f.indexOf(s[2])}"
}