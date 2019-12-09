package net.projecteuler.problems

import net.projecteuler.math.gcd
import kotlin.math.abs

/**
 * The closest fractions (n/d) to 3/7 are the fractions with the largest d and n = trunc(d*3/7).
 *
 * Start at d = 1000000 and, going down, Find the largest n for each that satisfies n/d < 3/7 and gcd(n,d) = 1.
 * The largest fraction is 428570/999997 which is very close to the trivial 428571/1000000 (a non-proper fraction).
 */

fun main() = println(orderedFractions())

private fun orderedFractions(): Int {
    val a = 3.0/7
    var min = Double.MAX_VALUE
    var minN = 0

    for(d in 1000000 downTo 8) {
        var n = (a*d).toInt()
        if(gcd(n, d) != 1) while(gcd(n, d) != 1) n--
        val t = abs(n.toDouble()/d - a)
        if(t < min) {
            min = t
            minN = n
        }
    }
    return minN
}

