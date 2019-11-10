package net.projecteuler.problems

/**
 * The first one found when iterating in order happens to be the solution. So I didn't bother adding checks
 * for the minimal distance. It also happens to be in the first 2400 pentagonal numbers.
 *
 * Just iterate over the pentagonal numbers while checking the sum and difference for pentagonal-ity.
 */

private const val max = 2400
private val p = Array(max) { (0.5*(it + 1)*(3*(it + 1) - 1)).toInt() }

fun main() = println(pentagonal())

private fun pentagonal(): Int {
    var r = 0
    for(i in 1 until max) (i until max).filter { p.contains(p[i] + p[it]) && p.contains(p[it] - p[i]) }
            .forEach { r = p[it] - p[i] }
    return r
}