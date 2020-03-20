package solutions

import math.PrimeSieve
import math.isPrime

/**
 * Iterate over i and j then check the sum of the i-th to j-th prime, if it is prime and the number of primes
 * summed to get it is maximal we save it and the result of the addition.
 *
 * We then return the maximal prime.
 */

private const val e = 7000
private val p = PrimeSieve.getSieve().getPrimes(e)

fun consecutivePrimeSum(): Int {
    var max = 0
    var r = 0
    for(i in 0 until p.size) {
        var s = 0
        for(j in i until p.size) {
            s += p[j]
            if(s.isPrime() && j - i > max && s < 1000000) {
                max = j - i
                r = s
            }
        }
    }
    return r
}
