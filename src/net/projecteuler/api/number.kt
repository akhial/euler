package net.projecteuler.api

import java.lang.Math.*

/**
 * Gets a digit at the given index.
 *
 * @param index the index.
 */

operator fun <T : Number> T.get(index: Int, len: Int = length()): Int {
    val n = this.toLong()
    var exp = (len - index - 1).toDouble()
    if(exp < 0) exp = 0.0
    val digit = n/Math.pow(10.0, exp)
    return (digit%10).toInt()
}

/**
 * Returns the length of a number in digits.
 */
fun <T : Number> T.length(): Int {
    var n = toLong()
    var len = 0
    if(n == 0L) return 1
    while(n > 0) {
        n /= 10
        len++
    }
    return len
}

/**
 * Sets the digit at the given index to the given digit.
 *
 * @param digit the digit
 * @param index the index must be >0 and <length
 */
fun <T : Number> T.setDigit(index: Int, digit: Int, len: Int = length()): Long {
    val n = this.toLong()
    if(digit < 0 || digit > 9) return n
    if(index < 0 || index > len - 1) return n
    return n + (pow(10.0, (len - index) - 1.0)*(digit - this[index])).toLong()
}

/**
 * One-liner that returns the GCD of two integers.
 */
fun gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a%b)

/**
 * One-liner that shifts all digits circularly to the right.
 * eg: 123456 -> 612345
 */
fun Int.shr() = ((this%10)*pow(10.0, length().toDouble() - 1) + this/10).toInt()

/**
 * Return the reversed representation of the given int.
 * eg: 123456 -> 654321
 */
fun <T : Number> T.reverse(): Long {
    val len = length()
    var result = pow(10.0, len.toDouble() - 1).toLong()
    for(i in 0 until len)
        result = result.setDigit(len - i - 1, this[i])
    return result
}

/**
 * Return true if int is prime.
 *
 * @see [Primes.isPrime].
 */
fun <T : Number> T.isPrime() = Primes.isPrime(toLong())

/**
 * Returns true if the number is a permutation of the other number. (Best synopsis ever btw)
 */
fun <T : Number> T.isPermutationOf(o: T): Boolean {
    val a = toLong()
    val b = o.toLong()
    val len = a.length()
    if(len != b.length()) return false
    val digits = Array(10) {0}
    a.digits().map { it.toInt() }.forEach { digits[it]++ }
    b.digits().map { it.toInt() }.forEach { digits[it]-- }
    return digits.all { it == 0 }
}

/**
 * Concatenates two ints into a long.
 */
infix fun Int.add(o: Int) = (toString() + o.toString()).toLong()

/**
 * Returns an [IntArray] containing the digits of the given number.
 */
fun Int.digits(len: Int = length()) = IntArray(len) { this[it, len] }

fun Long.digits(len: Int = length()) = LongArray(len) { this[it, len].toLong() }

/**
 * Returns true if the given number has unique digits, false otherwise.
 */
fun Int.hasUniqueDigits(): Boolean {
    val dg = digits()
    return dg.none { d -> dg.count { it == d } > 1 }
}

/**
 * Returns true if the int is pandigital.
 * A number is pandigital if it uses all the digits from 1 to len once and only once.
 *
 * @param len the number of digits.
 */
fun Int.isPandigital(len: Int): Boolean {
    if(length() != len || len > 9) return false
    val indices = (0 until len).map { this[it, len] - 1 }
    return indices.containsAll((0 until len).toList())
}

/**
 * A recursive function which returns an [IntArray] containing all the permutations of the digits given in
 * the calling object, permutations meaning arrangements with no repeats (!!!).
 *
 * @param prefix the currently generated permutation.
 * @param exp the index of the digit we are currently generating.
 */
fun IntArray.permutations(prefix: Int = 0, exp: Int = size - 1): IntArray {
    if(exp == 0) return intArrayOf(prefix + this[0])

    var s = intArrayOf()
    for(i in 0..exp) {
        val adv = prefix + pow(10.0, exp.toDouble())*this[i]
        var c = count { it == this[i] }
        var f = filter { it != this[i] }
        while(c-- > 1) f = f.plus(this[i])
        s = s.plus(f.toIntArray().permutations(adv.toInt(), exp - 1))
    }
    return s
}

fun IntRange.permutations() = toList().toIntArray().permutations()

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
        var c = count { it == this[i] }
        var f = filter { it != this[i] }
        while(c-- > 1) f = f.plus(this[i])
        s = s.plus(f.toIntArray().permutations(adv.toInt(), exp - 1, mask = pow))
    }
    return s
}

fun IntRange.permutations(len: Int) = toList().toIntArray().permutations(len = len)

/**
 * Returns all possible arrangements of the given digits in order, use when the number of digits exceeds 9.
 *
 * You can also use [IntRange.permutations].
 */
fun LongArray.permutations(prefix: Long = 0, exp: Int = size - 1): LongArray {
    if(exp == 0) return longArrayOf(prefix + this[0])

    var s = longArrayOf()
    for(i in 0..exp) {
        val adv = prefix + Math.pow(10.0, exp.toDouble())*this[i]
        var c = count { it == this[i] }
        var f = filter { it != this[i] }
        while(c-- > 1) f = f.plus(this[i])
        s = s.plus(f.toLongArray().permutations(adv.toLong(), exp - 1))
    }
    return s
}
