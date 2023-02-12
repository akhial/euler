package solutions

import math.PrimeFactors

/**
 * TODO Solve
 */

private val numbers = IntArray(10)

fun productSumNumbers(): Int {
    PrimeFactors.init(127)
    for(n in 4..16) {
        val f = PrimeFactors.of(n)
        for(k in 2..12) {
            for(p in f.factors) {
                TODO("Check all products: 4x3, 2x2x3 etc.")
            }
        }
    }
    return numbers.distinct().sum()
}
