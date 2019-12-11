package solutions

import java.math.BigInteger

/**
 * The minimal solution to this diophantine equation is called the fundamental solution, and if we denote the continued
 * fraction convergents to sqrt(d) by xi/yi then the fundamental solution is equal to (xi, yi) for some i.
 *
 * All we have to do to find this solution is iterate over sqrt(d)'s convergents until we find a pair that satisfies
 * the equation, all while keeping track of the maximal X value. Use [BigInteger].
 *
 * Also see _064.kt and _065.kt for cfSqrt() and cfCalc() respectively.
 *
 * Further reading: https://en.wikipedia.org/wiki/Pell's_equation
 */

fun diophantineEquation(): Int {
    var maxD = 2
    var maxX = BigInteger.ZERO

    for(d in 2..1000) {
        val f = cfSqrt(d)
        val c = ArrayList(f.drop(1))
        val n = ArrayList(f.take(1))
        var i = 0
        var found = false
        if(f.size == 1) found = true

        while(!found) {
            val cf = cfCalc(n)
            val x = cf.second
            val y = cf.first

            if(x.times(x) - BigInteger.valueOf(d.toLong()).times(y).times(y) == BigInteger.ONE) {
                if(x > maxX) {
                    maxX = x
                    maxD = d
                }
                found = true
            }
            n.add(c[i++%c.size])
        }
    }
    return maxD
}

