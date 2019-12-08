package net.projecteuler.problems

import net.projecteuler.api.Factorial
import java.math.BigInteger

/**
 * Use [BigInteger].
 */

fun main() = println(combinatoricSelections())

private fun combinatoricSelections() = (1..100).sumBy { n ->
    (0 until 100).count {
        ncr(n, it) > BigInteger.valueOf(1000000)
    }
}

private fun ncr(n: Int, r: Int) = f(n)/(f(r)*f(n - r))

private fun f(n: Int) = Factorial.largeFactorial(n)