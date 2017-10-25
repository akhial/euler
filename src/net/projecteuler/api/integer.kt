package net.projecteuler.api

/**
 * Gets a digit at the given index.
 *
 * @param index the index.
 */
fun Int.getDigit(index: Int): Int {
    var exp = (this.length() - index - 1).toDouble()
    if(exp < 0) exp = 0.0
    val digit = this/Math.pow(10.0, exp).toInt()
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
    if(this.length() != len || len > 9) return false
    val indices = (0 until len).map { this.getDigit(it) - 1 }
    return indices.containsAll((0 until len).toList())
}

/**
 * A recursive function which returns an [IntArray] containing all the permutations of the digits given in
 * the calling object, permutations meaning arrangements with no repeats.
 *
 * @param prefix the currently generated permutation.
 * @param exp the index of the digit we are currently generating.
 */
fun IntArray.permutations(prefix: Int = 0, exp: Int = this.size - 1): IntArray {
    if(exp == 0) return intArrayOf(prefix + this[0])

    var s = intArrayOf()
    for(i in 0..exp) {
        val adv = prefix + Math.pow(10.0, exp.toDouble())*this[i]
        s = s.plus(this.filter { it != this[i] }.toIntArray().permutations(adv.toInt(), exp - 1))
    }
    return s
}

/**
 * Same as [permutations] but stops when it reaches len digits. Used in problem 32.
 *
 * @param prefix the currently generated permutation.
 * @param exp the index of the digit we are currently generating.
 * @param len the length of the generated permutations. Used only in the first call.
 * @param mask a power of 10 generated only in the first call, used to check for base case.
 */
fun IntArray.permutations(prefix: Int = 0, exp: Int = this.size - 1, len: Int = this.size, mask: Int = 0): IntArray {
    val pow = if(prefix == 0) Math.pow(10.0, Math.max(this.size - len, 0).toDouble() + 1).toInt() else mask

    if(prefix%pow != 0) return intArrayOf(prefix/(pow/10))
    var s = intArrayOf()
    for(i in 0..exp) {
        val adv = prefix + Math.pow(10.0, exp.toDouble())*this[i]
        s = s.plus(this.filter { it != this[i] }.toIntArray().permutations(adv.toInt(), exp - 1, mask = pow))
    }
    return s
}

/**
 * One-liner that return the GCD of two integers.
 */
fun gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a%b)