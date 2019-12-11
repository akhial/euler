package solutions

import math.isPrime

/**
 * We calculate the number of primes on the nth border and add that to the accumulated total, the number of integers
 * on the diagonals is 2*n - 1 where n is the side length of the spiral.
 * When the ratio = primes / 2n-1 < 10 we stop.
 */

fun spiralPrimes(): Int {
    var ratio = 100
    var n = 3
    var p = 0
    while(ratio > 9) {
        p += (1..3).map { n*n - it*(n - 1) }.filter { it.isPrime() }.count()
        ratio = (p*100)/(2*n - 1)
        n += 2
    }
    return n - 2
}