package net.projecteuler.api

/**
 * Returns the length of a long in digits.
 */
fun Long.length(): Int {
    if(this == 0L) return 1
    var n = this
    var len = 0
    while(n > 0) {
        n /= 10
        len++
    }
    return len
}

/**
 * Gets the digit at the specified index.
 */
operator fun Long.get(index: Int, len: Int): Int {
    var exp = (len - index - 1).toDouble()
    if(exp < 0) exp = 0.0
    val digit = this/Math.pow(10.0, exp)
    return (digit%10).toInt()
}

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
        s = s.plus(filter { it != this[i] }.toLongArray().permutations(adv.toLong(), exp - 1))
    }
    return s
}