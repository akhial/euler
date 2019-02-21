package net.projecteuler.problems

import kotlin.math.*

/**
 * The tricky part was translating paper operations to an actual algorithm all while being wary of floating point
 * precision problems.
 * My first approach using doubles only worked for certain n (precision problems) the solution was converting the
 * algorithm to use only integer values.
 *
 * This particular implementation is from Daniel Fischer's answer on SO here:
 * https://stackoverflow.com/questions/12182701/generating-continued-fractions-for-square-roots
 */

fun main() = println(oddPeriodSquareRoots())

private fun oddPeriodSquareRoots(): Int = (2..10000).filter { cfSqrt(it).size%2 == 0 }.count()

fun cfSqrt(n: Int): ArrayList<Int> {
    val r = floor(sqrt(n.toDouble())).toInt()
    val f = arrayListOf<Int>()
    f.add(r)

    if(r*r == n) return f

    var a = r
    var p = 0
    var q = 1

    do {
        p = a*q - p
        q = (n - p*p)/q
        a = (r + p)/q
        f.add(a)
    } while(q != 1)

    return f
}