package net.projecteuler.problems

import net.projecteuler.api.getDigit
import net.projecteuler.api.getLength

/**
 * <p>When you use existing functions to get a digit at an index all you have to do is do the math.</p>
 * <p>The max is approximate due to the fact that 9^5 * 6 = 354294, so no number can be bigger and still be expressible.
 */

val max = 500_000

fun main(args: Array<String>) {
    val sum = (2..max)
            .filter { it.isSumExpressible(5) }
            .sum()
    println(sum)
}

fun Int.isSumExpressible(exponent: Int) : Boolean {
    val sum = (1..this.getLength()).sumBy { Math.pow(this.getDigit(it -1).toDouble(), exponent.toDouble()).toInt() }
    return this == sum
}