package solutions

import math.isPermutationOf
import math.phi

/**
 * Brute Force.
 *
 * See _069.kt for [phi].
 */

fun main() = println(totientPermutation())

private fun totientPermutation(): Int {
    var min = Double.MAX_VALUE
    var minC = 0

    for(c in 2..10_000_000) {
        val phi = phi(c)
        if(phi.isPermutationOf(c)) {
            val x = c.toDouble()/phi
            if(x < min) {
                min = x
                minC = c
            }
        }
    }
    return minC
}