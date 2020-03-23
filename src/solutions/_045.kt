package solutions

import kotlin.math.floor
import kotlin.math.sqrt

/**
 * Check each triangular after the 285th for pentagonal-ity and hexagonal-ity. Stop at the first one found.
 */

fun triangularPentagonalAndHexagonal(): Long {
    for(i in 285..100000L) {
        val n = (i + 1)*(i + 2)/2
        if(isP(n) && isH(n)) return n
    }
    return 0
}

private fun isP(n: Long): Boolean {
    val x = (-5 + sqrt((25 - 12*(2 - 2*n)).toDouble()))/6
    return x == floor(x)
}

private fun isH(n: Long): Boolean {
    val x = (-3 + sqrt((9 - 8*(1 - n)).toDouble()))/4
    return x == floor(x)
}
