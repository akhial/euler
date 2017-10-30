package net.projecteuler.problems

import java.math.BigInteger

/**
 * Use BigInteger and take the last 10 digits of the resulting string.
 */

fun main(args: Array<String>) {
    println(largeSeries())
}

private fun largeSeries(): String {
    var s = BigInteger.valueOf(10405071317)
    (11..1000).forEach { s += BigInteger.valueOf(it.toLong()).pow(it) }
    return s.toString().takeLast(10)
}