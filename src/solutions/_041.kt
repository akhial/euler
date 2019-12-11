package solutions

import math.isPrime
import math.permutations

/**
 * Iterate over the permutations of 1 to n digits for n < 9 then filter the primes and find the largest one.
 */

fun main() = println(pandigitalPrime())

private fun pandigitalPrime() = (1..9).map { n -> (1..n).toList().toIntArray().permutations().filter { it.isPrime() }.max() }.map { it ?: 0 }.max()!!