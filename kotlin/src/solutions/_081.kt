package solutions

import java.io.File
import kotlin.math.min

/**
 * Dynamic programming with recursion. Explore right and down at each value.
 */

private val n = File("res/p081_matrix.txt")
        .useLines { l -> l.map { it.split(",").map { s -> s.toInt() }.toIntArray() }.toList() }
private val m = Array(n.size) { IntArray(n.size) }

fun pathSumTwoWays(): Int = explore(0, 0)

private fun explore(r: Int, c: Int): Int {
    if(m[r][c] != 0) return m[r][c]
    val l = n.size - 1
    val x = n[r][c] + when {
        r == l && c == l -> 0
        r == l -> explore(r, c + 1)
        c == l -> explore(r + 1, c)
        else -> min(explore(r + 1, c), explore(r, c + 1))
    }
    m[r][c] = x
    return x
}
