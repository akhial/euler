package solutions

import java.io.File
import kotlin.math.min

/**
 * My initial approach was similar to problem 81, just added the direction r - 1 (up) and tweaked the stop condition
 * (reach the end column). This causes an infinite loop because to explore down you need to explore up and vice-versa.
 *
 * The fix was to track all moves taken prior to reaching the current location in array [v], this fills [v] with
 * a "snake" of set values. Similar to an actual game of snake, if the next move causes you to intersect yourself (the
 * string of locations you passed) then you consider that cell to be a "wall" (returning [Int.MAX_VALUE]).
 *
 * However, this lead to another problem. When using memoization and filling up [m] with the intermediate results,
 * you may put in [m] a value that wasn't the result of a "full" exploration, meaning that you've skipped exploring
 * a direction (in my case the 'up' direction) because you came from it. This fills [m] with wrong values.
 * To fix this I added the [f] flag which is flipped if we skip a direction. This tells us not to log the result in [m]
 * and to wait until we come from a different direction (in my case the 'down' direction) that allows us fully explore
 * the cell.
 */

private val n = File("../res/p081_matrix.txt")
        .useLines { l -> l.map { it.split(",").map { s -> s.toInt() }.toIntArray() }.toList() }
private val m = Array(n.size) { IntArray(n.size) }
private val v = Array(n.size) { BooleanArray(n.size) }
private var f = false

fun pathSumThreeWays() = n.indices.map { explore(it, 0) }.min()

private fun explore(r: Int, c: Int): Int {
    if(v[r][c]) {
        f = true
        return Int.MAX_VALUE
    }
    v[r][c] = true
    val x = if(m[r][c] != 0) {
        m[r][c]
    } else {
        val l = n.size - 1
        val x = n[r][c] + when {
            c == l -> 0
            r == 0 -> min(explore(r, c + 1), explore(r + 1, c))
            r == l -> min(explore(r, c + 1), explore(r - 1, c))
            else -> minOf(explore(r, c + 1), explore(r + 1, c), explore(r - 1, c))
        }
        if(!f) m[r][c] = x
        f = false
        x
    }
    v[r][c] = false
    return x
}
