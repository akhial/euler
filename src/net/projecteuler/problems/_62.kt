package net.projecteuler.problems

import net.projecteuler.api.isPermutationOf
import net.projecteuler.api.length

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
        val drop = Math.floor(Math.cbrt(Math.pow(10.0, (len - 1).toDouble()))).toInt() - 1
        val last = max - Math.ceil(Math.cbrt(Math.pow(10.0, len.toDouble()))).toInt() - 1
        val absLast = if(last < 0) 0 else last

        val candidates = cubes.drop(drop).dropLast(absLast)
        val i = candidates.count { it.isPermutationOf(c) }
        if(i == 5) return c
    }
    return 0
}