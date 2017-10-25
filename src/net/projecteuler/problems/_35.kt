package net.projecteuler.problems

import net.projecteuler.api.Primes

/**
 * Brute-force, the 78499th prime = 1000003 is the first prime over 1 million.
 *
 * @see [Primes.nthPrime], [Primes.isPrime].
 */

fun main(args: Array<String>) {
    println(circularPrimeCount())
}

fun circularPrimeCount(): Int {
    var count = 0
    for(i in 1 until 78499) {
        var prime = Primes.nthPrime(i).toString()
        var isCircular = true
        var j = 0
        while(isCircular && j < prime.length) {
            prime = prime.shl()
            isCircular = Primes.isPrime(Integer.parseInt(prime).toLong())
            j++
        }
        if(isCircular) count++
    }
    return count
}

fun String.shl(): String {
    if(this.length == 1) return this
    val sb = StringBuilder()
    sb.append(this.substring(1 until this.length))
    sb.append(this[0])
    return sb.toString()
}