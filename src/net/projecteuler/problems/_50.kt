package net.projecteuler.problems

import net.projecteuler.api.Factors
import net.projecteuler.api.isPrime

/**
 * Iterate over i and j then check the sum of the i-th to j-th prime, if it is prime and the number of primes
 * summed to get it is maximal we save it and the result of the addition.
 *
 * We then return the maximal prime. The limit of 600 primes was found after execution (precisely 545 primes).
 */

private val e = 600
private val p = Factors.getPrimes(e)

fun main(args: Array<String>) = println(consecutivePrimeSum())

private fun consecutivePrimeSum(): Int {
    var max = 0
    var r = 0
    for(i in 0 until e) {
        var s = 0
        for(j in i until e) {
            s += p[j]
            if(s.isPrime() && j - i > max && s < 1000000) {
                max = j - i
                r = s
            }
        }
    }
    return r
}