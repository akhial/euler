package net.projecteuler.problems

/**
 * The number of reduced proper functions with denominator d is the number of n < d with gcd(d, n)=1.
 * Also, phi(d) is the number of n < d with gcd(d, n)=1.
 *
 * So we sum the values of phi(n) with n in [2, 1000000].
 *
 * See _069.kt for [phi].
 */

fun main() = println(countingFractions())

private fun countingFractions() = (2..1000000).map { phi(it).toLong() }.sum()