package net.projecteuler.problems

import net.projecteuler.api.Primes
import net.projecteuler.api.isPrime
import net.projecteuler.api.length
import net.projecteuler.api.shr

/**
 * Brute-force, to check for circularity I shift the prime continuously to the right "length" times.
 * Checking if its prime each time.
 *
 * @see [Primes.nthPrime], [Primes.isPrime].
 */

fun main(args: Array<String>) = println(circularPrimeCount())

private fun circularPrimeCount(): Int {
    var count = 0
    for(n in 1 until 1000000) {
        if(n.isPrime()) {
            var prime = n
            var isCircular = true
            var j = 0
            while(isCircular && j < prime.length()) {
                prime = prime.shr()
                isCircular = prime.isPrime()
                j++
            }
            if(isCircular) count++
        }
    }
    return count
}