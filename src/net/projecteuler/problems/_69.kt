package net.projecteuler.problems

import net.projecteuler.api.gcd

/**
 * TODO solve.
 */

fun main() = println(totientMaximum())

private fun totientMaximum(): Int {
    val candidates = List(500000) { i -> i*2 }
    var max = 0.0
    var maxC = 0

    for(c in candidates) {
        val x = c.toDouble()/phi(c)
        if(x > max) {
            max = x
            maxC = c
        }
    }
    return maxC
}

private fun phi(n: Int): Int {
    var r = 1
    for(i in 1 until n/2) {
        if(gcd(n, i*2 + 1) == 1) r++
    }
    return r
}