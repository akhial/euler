package solutions

import java.io.File
import kotlin.math.min

/**
 * TODO Solve
 */

private val n = File("res/p081_matrix.txt")
        .useLines { l -> l.map { it.split(",").map { s -> s.toInt() }.toIntArray() }.toList() }
private val s = 5
private val m = Array(s) { IntArray(s) }
private val v = Array(s) { BooleanArray(s) }

fun main() = println(pathSumThreeWays())

private fun pathSumThreeWays(): Int {
    for(r in 0 until s) {
        println(explore(r, 0))
        m.forEach { it.forEach { print("$it\t") }; println() }
    }
    return 0
}

private fun explore(r: Int, c: Int): Int {
    if(v[r][c]) return Int.MAX_VALUE
    if(m[r][c] != 0) return m[r][c]
    v[r][c] = true
    val l = s - 1
    val x = n[r][c] + when {
        c == l -> 0
        r == 0 -> min(explore(r, c + 1), explore(r + 1, c))
        r == l -> min(explore(r, c + 1), explore(r - 1, c))
        else -> minOf(explore(r, c + 1), explore(r - 1, c), explore(r + 1, c))
    }
    m[r][c] = x
    v[r][c] = false
    return x
}