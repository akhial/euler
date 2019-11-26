package net.projecteuler.problems

import java.math.BigInteger

/**
 * Use BigInteger, then store in a set to remove duplicates.
 */

private const val maxA = 100
private const val maxB = 100

fun main() {
    val set = HashSet<BigInteger>()
    for(a in 2..maxA) {
        (2..maxB).mapTo(set) { BigInteger.valueOf(a.toLong()).pow(it) }
    }
    println(set.size)
}