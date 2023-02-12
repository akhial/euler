package solutions

import java.io.File

/**
 * Modified version of Dijkstra's algorithm.
 *
 * Further reading: https://en.wikipedia.org/wiki/Dijkstra's_algorithm
 */

private val n = File("../res/p081_matrix.txt")
        .useLines { l -> l.map { it.split(",").map { s -> s.toInt() }.toIntArray() }.toList() }
private val m = Array(n.size) { IntArray(n.size) { Int.MAX_VALUE } }
private val v = Array(n.size) { BooleanArray(n.size) }

fun pathSumFourWays(): Int {
    m[0][0] = n[0][0]
    var r = 0
    var c = 0
    val l = n.size - 1
    while(r != l || c != l) {
        var min = Int.MAX_VALUE
        for(i in 0..l) {
            for(j in 0..l) {
                if(!v[i][j] && m[i][j] < min) {
                    min = m[i][j]
                    r = i
                    c = j
                }
            }
        }
        v[r][c] = true
        val neighbors = when {
            r == 0 && c == 0 -> arrayOf(Pair(r + 1, c), Pair(r, c + 1))
            r == 0 && c == l -> arrayOf(Pair(r + 1, c), Pair(r, c - 1))
            r == l && c == 0 -> arrayOf(Pair(r, c + 1), Pair(r - 1, c))
            r == l && c == l -> arrayOf()
            r == 0 -> arrayOf(Pair(r + 1, c), Pair(r, c + 1), Pair(r, c - 1))
            c == 0 -> arrayOf(Pair(r + 1, c), Pair(r, c + 1), Pair(r - 1, c))
            r == l -> arrayOf(Pair(r, c + 1), Pair(r - 1, c), Pair(r, c - 1))
            c == l -> arrayOf(Pair(r + 1, c), Pair(r - 1, c), Pair(r, c - 1))
            else -> arrayOf(Pair(r + 1, c), Pair(r, c + 1), Pair(r - 1, c), Pair(r, c - 1))
        }
        for(x in neighbors) {
            val i = x.first
            val j = x.second
            if(!v[i][j]) {
                val t = m[r][c] + n[i][j]
                if(t < m[i][j]) {
                    m[i][j] = t
                }
            }
        }
    }
    return m[l][l]
}
