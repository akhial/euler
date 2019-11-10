package net.projecteuler.problems

import java.math.BigInteger

/**
 * Use [BigInteger].
 */

fun main() = println(powerfulDigitSum())

private fun powerfulDigitSum(): Int {
    var max = 0
    for(a in 1..100) {
        for(b in 1..100) {
            val s = BigInteger.valueOf(a.toLong()).pow(b).toString().toCharArray().map { it - '0' }.sum()
            if(s > max) max = s
        }
    }
    return max
}

