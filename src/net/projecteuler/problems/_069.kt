package net.projecteuler.problems

import net.projecteuler.api.Factors
import kotlin.math.roundToInt

/**
 * This checks all even numbers under 1000000 for the maximum (all odd numbers have larger totients because they are
 * relatively prime to all smaller even numbers).
 * It uses Euler's product formula to compute Euler's totient function, it states that:
 *  phi(n) = n*(1/1-p)*(1/1-q)*...*(1/1-z) where p,q,...,z are the prime factors of n
 * eg:
 *  phi(10) = phi(2*5) = 10*(1-1/2)*(1-1/5) = 10*0.4 = 4
 *
 *  Uses [Factors] to get the prime factors.
 *  Further reading: https://en.wikipedia.org/wiki/Euler's_totient_function
 */

fun main() = println(totientMaximum())

private fun totientMaximum(): Int {
    var max = 0.0
    var maxC = 0

    for(i in 1..500000) {
        val c = 2*i
        val x = c.toDouble()/phi(c)
        if(x > max) {
            max = x
            maxC = c
        }
    }
    return maxC
}

fun phi(n: Int): Int {
    var r = 1.0
    for(p in Factors.of(n).factors) r *= 1 - (1.0/p.first)
    return (n*r).roundToInt()
}