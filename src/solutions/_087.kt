package solutions

import math.PrimeSieve
import java.util.*

/**
 * Count the number of unique prime power sums, sqrt(50M) = 7072, cbrt(50M) = 369 and 50M^(1/4) = 85.
 */

private val x = PrimeSieve.getSieve().getPrimes(7072)
private val y = PrimeSieve.getSieve().getPrimes(369)
private val z = PrimeSieve.getSieve().getPrimes(85)
private val s = BitSet(50_000_000)

fun primePowerTriples(): Int {
    for(p in x) for(q in y) for(r in z) {
        val n = p*p + q*q*q + r*r*r*r
        if(n < 50_000_000) s.set(n)
    }
    return s.cardinality()
}