package net.projecteuler.problems

import net.projecteuler.api.fact
import net.projecteuler.api.get
import net.projecteuler.api.length

/**
 * Brute-force, the limit of 50000 was found through trial and error.
 */

fun main() = println(factSum())

private fun factSum(): Int {
    var result = 0
    for(n in 3..50000) {
        val sum = (0 until n.length()).sumBy { fact(n[it]).toInt() }
        if(sum == n) result += n
    }
    return result
}