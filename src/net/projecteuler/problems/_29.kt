package net.projecteuler.problems

import java.math.BigInteger

/**
 * <p>Use BigInteger, then store in a set to remove duplicates.</p>
 */

val maxA = 100
val maxB = 100

fun main(args: Array<String>) {
    val set = HashSet<BigInteger>()
    for(a in 2..maxA) {
        (2..maxB).mapTo(set) { BigInteger.valueOf(a.toLong()).pow(it) }
    }
    println(set.size)
}