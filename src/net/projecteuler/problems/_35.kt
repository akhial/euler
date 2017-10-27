package net.projecteuler.problems

import net.projecteuler.api.Primes
import net.projecteuler.api.length
import net.projecteuler.api.shr

/**
 * Brute-force, the 78499th prime = 1000003 is the first prime over 1 million.
 * Spectacularly inefficient because I re-calculate a full eratosthenes sieve for each prime but it works so meh.
 *
 * @see [Primes.nthPrime], [Primes.isPrime].
 */

fun main(args: Array<String>) {
    println(circularPrimeCount())
}

fun circularPrimeCount(): Int {
    var count = 0
    for(i in 1 until 78499) {
        var prime = Primes.nthPrime(i)
        var isCircular = true
        var j = 0
        while(isCircular && j < prime.length()) {
            prime = prime.shr()
            isCircular = Primes.isPrime(prime.toLong())
            j++
        }
        if(isCircular) count++
    }
    return count
}