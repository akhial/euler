package solutions

import math.isPermutationOf
import math.length
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow

/**
 * At first I tried getting all permutations for each cube then counting the numbers of those permutations that
 * are contained in the cubes array.
 *
 * That turned out to be prohibitively inefficient so I tried doing it the other way around, finding the potential
 * cubes and then checking if they were permutations. This finds the answer in about 30s on my i5-4300u.
 */

private const val max = 10000
private val cubes = LongArray(max) { it*it*it.toLong() }

fun main() = println(cubicPermutations())

private fun cubicPermutations(): Long {
    for(c in cubes) {
        val len = c.length()
        val drop = floor(Math.cbrt(10.0.pow((len - 1).toDouble()))).toInt() - 1
        val last = max - ceil(Math.cbrt(10.0.pow(len.toDouble()))).toInt() - 1
        val absLast = if(last < 0) 0 else last

        val candidates = cubes.drop(drop).dropLast(absLast)
        val i = candidates.count { it.isPermutationOf(c) }
        if(i == 5) return c
    }
    return 0
}