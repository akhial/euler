package net.projecteuler.problems

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.math.max
import kotlin.streams.toList

/**
 * Changed the solution in _18.java to use memoization. This yields a very fast result.
 */


private const val numberOfRows = 100
private val sums = MutableList(100) { index -> MutableList(index + 1) { 0 } }

fun main(args: Array<String>) = println(maximumPathSum())

private fun maximumPathSum(): Int {
    val l = Files.lines(Paths.get("res/triangle.txt"))
    val t = l.toList().map { it.split(" ") }

    sum(t, 0, 0)
    return sums[0][0]
}

private fun sum(t: List<List<String>>, row: Int, column: Int) {
    if(row == numberOfRows - 1) {
        for(c in 0..column)
            sums[row][c] = t[row][c].toInt()
        return
    }
    sum(t, row + 1, column + 1)

    for(c in 0..column)
        sums[row][c] = max(sums[row + 1][c], sums[row + 1][c + 1]) + t[row][c].toInt()
}