package net.projecteuler.problems

import java.math.BigInteger

/**
 * In the sequence:
 *      1 +          1
 *          -------------------
 *          2 +        1
 *              ---------------
 *              2 +      1
 *                  -----------
 *                  2 +  ...
 *
 * You can calculate the results 2 + 1/(...) recursively where (...) = 2/1 is the base case.. then the next iteration is
 * the twice the numerator of (...) + the it's denominator / by the numerator of (...). I store both of them in a [Pair].
 * I also use memoization to store the results of previous iterations to minimize cost. Use [BigInteger].
 *
 * The final step is finding the pairs which have longer numerators and counting them.
 */

private val zero = Pair(BigInteger.ZERO, BigInteger.ZERO)
private val pairs = Array(1000) { zero }

fun main() = println(squareRootConvergents())

private fun squareRootConvergents(): Int = (1..1000)
        .map { sqrt(it) }
        .map { Pair(it.first + it.second, it.first) }
        .count { it.first.toString().length > it.second.toString().length }

private fun sqrt(i: Int): Pair<BigInteger, BigInteger> {
    if(i == 1) return Pair(BigInteger.valueOf(2L), BigInteger.ONE)
    val sqrt = sqrt(i - 1)
    val p = pairs[i - 1]
    return if(p != zero) p else {
        val r = Pair(sqrt.first.shiftLeft(1) + sqrt.second, sqrt.first)
        pairs[i - 1] = r
        r
    }
}