package solutions

import math.PrimeFactors
import math.phi

/**
 * The number of reduced proper functions with denominator d is the number of n < d with gcd(d, n)=1.
 * Also, phi(d) is the number of n < d with gcd(d, n)=1.
 *
 * So we sum the values of phi(n) with n in [2, 1000000].
 */

fun countingFractions(): Long {
    PrimeFactors.init(1000000)
    return (2..1000000).map { phi(it).toLong() }.sum()
}
