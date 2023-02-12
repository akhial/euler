package solutions

import math.PrimeFactors

/**
 * Iterates over n using memoization to save previously calculated factors. Always calculating the
 * (n+4)th factor in advance. Stops at the first sequence of 4 numbers whose factor count is 4.
 *
 * @see [PrimeFactors].
 */

fun distinctPrimesFactors(): Int {
    val factors = arrayListOf<PrimeFactors>()
    var found = false
    var n = 0
    PrimeFactors.init(140000)

    (0 until 4).mapTo(factors) { PrimeFactors.of(it) }
    while(!found) {
        factors.add(PrimeFactors.of(n + 4))
        if(factors[n].factors.count() == 4 &&
                factors[n + 1].factors.count() == 4 &&
                factors[n + 2].factors.count() == 4 &&
                factors[n + 3].factors.count() == 4) found = true
        n++
    }
    return n - 1
}
