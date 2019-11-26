package net.projecteuler.problems

/**
 * One has to notice that the top-right diagonal is just the squares of the column number,
 * then you find that the four corners are that square minus the column number - 1. eg:
 *
 *          21 22 23 24 25 <- 25 = 5*5
 *          20  7  8  9 10
 *          19  6  1  2 11
 *          18  5  4  3 12
 *          17 16 15 14 13
 *
 *          21 = 25 -4
 *          17 = 25 -4 -4
 *          13 = 25 -4 -4 -4
 *
 * Hence this solution.
 */

private const val spiralSize = 1001

fun main() = println(spiralSum(spiralSize))

private fun spiralSum(size: Int): Int {
    var sum = 1
    var i = 3
    while(i <= size) {
        val n = i*i
        val v = i - 1
        sum += 4*n - 6*v
        i += 2
    }
    return sum
}