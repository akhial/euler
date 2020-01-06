package solutions

import kotlin.math.abs

/**
 * Think of it as the number of positions you can place a rectangle:
 * The x coordinate increases until you exceed the enclosing rectangle size, so x_max = length - subRectLength + 1.
 * The y coordinate increases in the same way, so y_max = width - subRectWidth + 1.
 * We add 1 because of the initial '0' position.
 *
 * Multiply the two to get the total number of positions for each sub-rectangle, do it for all of them. Profit!
 */

fun countingRectangles(): Int {
    var minResidual = Int.MAX_VALUE
    var min = Int.MAX_VALUE
    for(n in 2..100) {
        for(m in n..100) {
            val r = abs(2_000_000 - subRectangleCount(n, m))
            if(r < minResidual) {
                minResidual = r
                min = n*m
            }
        }
    }
    return min
}

private fun subRectangleCount(n: Int, m: Int): Int {
    var c = 0
    for(i in 1..n) {
        for(j in 1..m) {
            val x = n - i + 1
            val y = m - j + 1
            c += x*y
        }
    }
    return c
}