package net.projecteuler.problems

import net.projecteuler.math.get
import net.projecteuler.math.permutations
import net.projecteuler.math.setDigit

/**
 * I first generate all 10-digit pandigital permutations, then I construct the 3-digit sequences in a loop.
 * All while checking for divisibility by the corresponding prime.
 *
 * @see [Int.setDigit], [LongArray.permutations].
 */

private val primes = intArrayOf(2, 3, 5, 7, 11, 13, 17)

fun main() = println(divisiblePandigitals())

private fun divisiblePandigitals(): Long {
    val d = longArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val p = d.permutations()
    var t = 0L
    for(c in p) {
        var r = true
        for(n in 1 until 8) {
            var s = 0
            for(j in 0..2) s = s.setDigit(j, c[n + j], 3)
            r = r && s%primes[n - 1] == 0
            if(!r) break
        }
        if(r) t += c
    }
    return t
}