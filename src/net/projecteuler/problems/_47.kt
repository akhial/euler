package net.projecteuler.problems

import net.projecteuler.api.Factors

/**
 * Iterates over n using memoization to save previously calculated factors. Always calculating the
 * (n+4)th factor in advance. Stops at the first sequence of 4 numbers whose factor count is 4.
 *
 * @see [Factors].
 */

fun main(args: Array<String>) = println(distinctPrimeFactors())

private fun distinctPrimeFactors(): Int {
    val factors = arrayListOf<Factors>()
    var found = false
    var n = 0
    (0 until 4).mapTo(factors) { Factors.of(it) }
    while(!found) {
        factors.add(Factors.of(n + 4))
        if(factors[n].count() == 4 &&
                factors[n + 1].count() == 4 &&
                factors[n + 2].count() == 4 &&
                factors[n + 3].count() == 4) found = true
        n++
    }
    return n - 1
}