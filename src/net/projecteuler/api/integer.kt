package net.projecteuler.api

import java.lang.Math.*

/**
 * Gets a digit at the given index.
 *
 * @param index the index.
 */
fun Int.getDigit(index: Int, len: Int = length()): Int {
    var exp = (len - index - 1).toDouble()
    if(exp < 0) exp = 0.0
    val digit = this/pow(10.0, exp).toInt()
    return digit%10
}

/**
 * Returns the length of a number in digits.
 */
fun Int.length(): Int {
    if(this == 0) return 1
    var n = this
    var len = 0
    while(n > 0) {
        n /= 10
        len++
    }
    return len
}

/**
 * Returns true if the int is pandigital.
 * A number is pandigital if it uses all the digits from 1 to len once and only once.
 *
 * @param len the number of digits.
 */
fun Int.isPandigital(len: Int): Boolean {
    if(length() != len || len > 9) return false
    val indices = (0 until len).map { getDigit(it, len) - 1 }
    return indices.containsAll((0 until len).toList())
}

/**
 * A recursive function which returns an [IntArray] containing all the permutations of the digits given in
 * the calling object, permutations meaning arrangements with no repeats.
 *
 * @param prefix the currently generated permutation.
 * @param exp the index of the digit we are currently generating.
 */
fun IntArray.permutations(prefix: Int = 0, exp: Int = size - 1): IntArray {
    if(exp == 0) return intArrayOf(prefix + this[0])

    var s = intArrayOf()
    for(i in 0..exp) {
        val adv = prefix + pow(10.0, exp.toDouble())*this[i]
        s = s.plus(filter { it != this[i] }.toIntArray().permutations(adv.toInt(), exp - 1))
    }
    return s
}

fun IntRange.permutations(): IntArray = toList().toIntArray().permutations()

/**
 * Same as [permutations] but stops when it reaches len digits. Used in problem 32.
 *
 * @param prefix the currently generated permutation.
 * @param exp the index of the digit we are currently generating.
 * @param len the length of the generated permutations. Used only in the first call.
 * @param mask a power of 10 generated only in the first call, used to check for base case.
 */
fun IntArray.permutations(prefix: Int = 0, exp: Int = size - 1, len: Int = size, mask: Int = 0): IntArray {
    val pow = if(prefix == 0) pow(10.0, max(size - len, 0).toDouble() + 1).toInt() else mask

    if(prefix%pow != 0) return intArrayOf(prefix/(pow/10))
    var s = intArrayOf()
    for(i in 0..exp) {
        val adv = prefix + pow(10.0, exp.toDouble())*this[i]
        s = s.plus(filter { it != this[i] }.toIntArray().permutations(adv.toInt(), exp - 1, mask = pow))
    }
    return s
}

fun IntRange.permutations(len: Int): IntArray = toList().toIntArray().permutations(len = len)

/**
 * One-liner that return the GCD of two integers.
 */
fun gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a%b)

/**
 * One-liner that shifts all digits circularly to the right.
 * eg: 123456 -> 612345
 */
fun Int.shr(): Int = ((this%10)*pow(10.0, length().toDouble() - 1) + this/10).toInt()

/**
 * Return the reversed representation of the given int.
 * eg: 123456 -> 654321
 */
fun Int.reverse(): Int {
    var result = pow(10.0, length().toDouble() - 1).toInt()
    for(i in 0 until length())
        result = result.setDigit(getDigit(i), length() - i - 1)
    return result
}

/**
 * Sets the digit at the given index to the given digit.
 *
 * @param digit the digit
 * @param index the index must be >0 and <length
 */
fun Int.setDigit(digit: Int, index: Int): Int {
    if(digit < 0 || digit > 9) return this
    if(index < 0 || index > length() - 1) return this
    return this + (pow(10.0, (length() - index) - 1.toDouble())*(digit - getDigit(index))).toInt()
}

/**
 * Return true if int is prime.
 *
 * @see [Primes.isPrime].
 */
fun Int.isPrime(): Boolean = Primes.isPrime(this)