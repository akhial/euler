package solutions

import math.isPrime
import math.permutations

/**
 * Iterate over the permutations of 1 to n digits for n < 9 then filter the primes and find the largest one.
 */
fun pandigitalPrime() =
    (1..9).mapNotNull { n ->
        (1..n).toList().toIntArray().permutations().filter { it.isPrime() }.maxOrNull()
    }.max()
