package net.projecteuler.problems

import net.projecteuler.api.*

/**
 * Iterate over the permutations of 1 to n digits for n < 9 then filter the primes and find the largest one.
 */

fun main(args: Array<String>) {
    println(pandigitalPrime())
}

private fun pandigitalPrime(): Int =
        (1..9).map { n -> (1..n).permutations().filter { it.isPrime() }.max() }.map { it ?: 0 }.max()!!