package solutions

import math.get
import math.length
import kotlin.math.pow

/**
 * When you use existing functions to get a digit at an index all you have to do is do the math.
 * The max is approximate due to the fact that 9^5 * 6 = 354294, so no number can be bigger and still be expressible.
 */

private const val max = 500_000

fun digitFifthPowers(): Int = (2..max)
        .filter { it.isSumExpressible(5) }
        .sum()

private fun Int.isSumExpressible(exponent: Int) =
        this == (1..this.length()).sumOf { this[it - 1].toDouble().pow(exponent.toDouble()).toInt() }
