package solutions

import math.gcd

/**
 * Generate all primitive triple sums < l = 1500000 using Euler's formula: Every triplet (a, b, c) of the form
 * a = m^2 + n^2
 * b = 2*m*n
 * c = m^2 - n^2
 * is a pythagorean triple, also when m and n are coprime and not both odd the triple is primitive.
 *
 * If a certain triple (a, b, c) gives a sum S it also gives all sums k*S for positive k.
 * So for each triple sum S we increment the number of unique sums for each k*S less than l, and keep track of
 * them in the array c.
 * We then find how many numbers have only one primitive sum, ie: c['candidate'] = 1
 *
 * Further reading: https://en.wikipedia.org/wiki/Pythagorean_triple
 */

fun main() = println(singularIntegerRightTriangles())

private fun singularIntegerRightTriangles(): Int {
    val l = 1500000
    val c = IntArray(l + 1)
    val triples = generateTriples().filter { it <= 1500000 }

    for(t in triples) {
        var k = t
        while(k <= l) {
            c[k]++
            k += t
        }
    }
    return c.count { it == 1 }
}

private fun generateTriples(): IntArray {
    val t = IntArray(152236) // pre-calculated
    var i = 0
    for(m in 2..866) { // sqrt(1500000/2) = 866
        for(n in 1 until m) {
            if((m + n)%2 == 0 || gcd(m, n) != 1) continue
            t[i++] = (m + n)*m*2 // a + b + c
        }
    }
    return t
}