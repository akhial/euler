package net.projecteuler.problems

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.math.min
import kotlin.streams.toList

/**
 * Dynamic programming with recursion. Explore right and down at each value.
 */

private val n = Files.lines(Paths.get("res/p081_matrix.txt"))
        .map { it.split(",").map { s -> s.toInt() }.toIntArray() }.toList().toTypedArray()
private val l = n.size - 1
private val m = Array(n.size) { IntArray(n.size) }

fun main() = println(pathSumTwoWays())

private fun pathSumTwoWays(): Int {
    return explore(0, 0)
}

private fun explore(r: Int, c: Int): Int {
    if(m[r][c] != 0) return m[r][c]
    val x = n[r][c] + when {
        r == l && c == l -> 0
        r == l -> explore(r, c + 1)
        c == l -> explore(r + 1, c)
        else -> min(explore(r + 1, c), explore(r, c + 1))
    }
    m[r][c] = x
    return x
}