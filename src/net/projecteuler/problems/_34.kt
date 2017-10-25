package net.projecteuler.problems

import net.projecteuler.api.*

/**
 * Brute-force, the limit of 50000 was found through trial and error.
 */

fun main(args: Array<String>) {
    println(factSum())
}

fun factSum(): Int {
    var result = 0
    for(n in 3..50000) {
        val sum = (0 until n.length()).sumBy { Factorial.factorial(n.getDigit(it)).toInt() }
        if(sum == n) result += n
    }
    return result
}