package net.projecteuler.problems

import net.projecteuler.math.PrimeSieve

/**
 * Same as problem 76, except instead of branching from root 'n' into all numbers under 'n' we only traverse branches
 * with a prime root.
 */

private val primes = PrimeSieve.getSieve().getPrimes(80)
private var n = 10

fun main() = println(primeSummations())

private fun primeSummations(): Int {
    while(explore(n - 1, 0) < 5000) n++
    return n
}

private fun explore(x: Int, s: Int): Int {
    var c = 0
    if(s == n)
        c++
    else
        for(i in primes.takeWhile { it <= x }.reversed())
            if(s + i <= n)
                c += explore(i, s + i)
    return c
}