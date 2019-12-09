package net.projecteuler.problems

import net.projecteuler.math.length
import kotlin.math.pow

/**
 * Bounded brute-force, the highest n is 10 because len(10^n) = n+1 for all n
 * Highest that gives a result is 21, with 9^20 and 9^21 being the two numbers, so I just add 2 to the count of numbers
 * with exponents less than 20. This is because 9^20 > MAX_LONG.
 */

fun main() = println(powerfulDigitCounts())

private fun powerfulDigitCounts(): Int {
    var count = 0
    for(exp in 1..19) {
        for(n in 1..9) {
            val r = n.toDouble().pow(exp).toLong()
            if(r.length() == exp) count++
        }
    }
    return count + 2
}