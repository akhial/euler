package solutions

import java.math.BigInteger

/**
 * First generate an array of coefficients for the continued fraction, then start from the end and work your way
 * to the start while keeping track of the current fraction.
 *
 * Uses the recursive formula: nextFraction = (lastDenominator, currentCoefficient*lastNominator + lastDenominator)
 */

private val cf = Array(100) { if(it == 0) 2 else if(it%3 == 2) 2*(it + 1)/3 else 1 }

fun main() = println(convergentsOfE())

private fun convergentsOfE(): Int = cfCalc(ArrayList(cf.asList())).second.toString().map { Character.getNumericValue(it) }.sum()

fun cfCalc(cf: ArrayList<Int>): Pair<BigInteger, BigInteger> {
    var c = Pair(BigInteger.ONE, BigInteger.valueOf(cf.last().toLong()))
    for(i in cf.reversed().drop(1))
        c = Pair(c.second, c.second.times(BigInteger.valueOf(i.toLong())) + c.first)
    return c
}