package net.projecteuler.problems

import net.projecteuler.api.gcd

/**
 * Brute force. Find the number of pairs (n, d) that satisfy: n < d, gcd(n, d)=1 and a < n/d < b.
 */

fun main() = println(countingFractionsInARange())

private fun countingFractionsInARange(): Int {
    val a = 1.0/3
    val b = 0.5
    var r = 0

    for(d in 5..12000)
        for(n in 2..d)
            if(gcd(d, n) == 1 && n.toDouble()/d > a && n.toDouble()/d < b) r++
    return r
}