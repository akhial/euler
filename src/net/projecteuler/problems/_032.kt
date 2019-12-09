package net.projecteuler.problems

import net.projecteuler.math.get
import net.projecteuler.math.isPandigital
import net.projecteuler.math.length
import net.projecteuler.math.permutations

/**
 * The main challenge-ish with this problem was finding the permutations of given digits with a given length.
 * For that I used a recursive function:
 *
 * We try all digits in an [IntArray] at the beginning and proceed to generate the remaining digits. We keep
 * track of the digits we've used in an [IntArray]. The base case is when we reach the assigned number of digits.
 *
 * For the pandigital part I retrieve all digits in a number then check if the range containing them also contains
 * the range 0 until 9, since we need 9-digit pandigital products.
 *
 * @see [permutations], [isPandigital].
 */

private val digits = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

fun main() = println(pandigitalProducts())

private fun pandigitalProducts(): Int {
    val products = HashSet<Int>()
    for(a in 1 until 10)
        digits.filter { it != a }.toIntArray().permutations(length = 4)
                .filter { isPanProduct(a, it) }
                .forEach { products.add(a*it) }
    for(a in (1 until 10).toList().toIntArray().permutations(length = 2))
        digits.filter { it != a[0] && it != a[1] }.toIntArray().permutations(length = 3)
                .filter { isPanProduct(a, it) }
                .forEach { products.add(a*it) }
    return products.sum()
}

private fun isPanProduct(a: Int, b: Int): Boolean {
    val product = a*b
    if(product.length() > 4) return false
    val s = a.toString() + b.toString() + product.toString()
    val t = Integer.parseInt(s)
    return t.isPandigital()
}