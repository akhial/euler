package math

import java.math.BigInteger
import kotlin.math.roundToInt

private val smallFactorials = longArrayOf(
        1,
        1,
        2,
        6,
        24,
        120,
        720,
        5040,
        40320,
        362880,
        3628800,
        39916800,
        479001600,
        6227020800,
        87178291200,
        1307674368000,
        20922789888000,
        355687428096000,
        6402373705728000,
        121645100408832000,
        2432902008176640000
)

fun fact(n: Int): Long {
    if(n > 20 || n < 0) {
        throw IllegalArgumentException("$n")
    }
    return smallFactorials[n]
}

fun bigFact(n: Int): BigInteger {
    var c = BigInteger.ONE
    fun product(n: Int): BigInteger {
        val m = n/2
        if(m == 0) {
            c += BigInteger.TWO
            return c
        }
        if(n == 2) {
            c += BigInteger.valueOf(4)
            return c*(c - BigInteger.TWO)
        }
        return product(n - m)*product(m)
    }
    return when {
        n < 0 -> throw IllegalArgumentException("$n")
        n < 21 -> BigInteger.valueOf(fact(n))
        else -> {
            c = BigInteger.ONE
            var p = BigInteger.ONE
            var r = BigInteger.ONE
            var h = 0
            var shift = 0
            var high = 1
            var log2n = kotlin.math.log2(n.toDouble()).toInt()
            while(h != n) {
                shift += h
                h = n shr log2n--
                var len = high
                high = (h - 1) or 1
                len = (high - len)/2
                if(len > 0) {
                    p *= product(len)
                    r *= p
                }
            }
            return r shl shift
        }
    }
}

fun phi(n: Int): Int {
    var r = 1.0
    for(p in PrimeFactors.of(n).factors) r *= 1 - (1.0/p.first)
    return (n*r).roundToInt()
}

fun powerOfTen(a: Int): Long {
    var r = 1L
    repeat(a.coerceAtLeast(0)) { r *= 10 }
    return r
}

fun gcd(a: Int, b: Int) = gcd(a.toLong(), b.toLong()).toInt()

fun gcd(a: Long, b: Long): Long = if(b == 0L) a else gcd(b, a%b)

operator fun <T : Number> T.get(index: Int): Int {
    val a = length() - index - 1
    val digit = toLong()/powerOfTen(a)
    return (digit%10).toInt()
}

fun Int.setDigit(index: Int, digit: Int, padding: Int = length()) =
        toLong().setDigit(index, digit, padding).toInt()

fun Long.setDigit(index: Int, digit: Int, padding: Int = length()): Long {
    if(digit < 0 || digit > 9) {
        throw IllegalArgumentException("$digit")
    }
    if(index < 0 || index > padding - 1) {
        throw ArithmeticException("index out of bounds: $index")
    }
    return this + powerOfTen(padding - index - 1)*(digit - this[index])
}

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

fun Int.reverse() = toLong().reverse().toInt()

fun Long.reverse(): Long {
    val length = length()
    var result = powerOfTen(length - 1)
    for(i in 0 until length) {
        result = result.setDigit(length - i - 1, this[i])
    }
    return result
}

fun <T : Number> T.isPrime() = PrimeUtils.isPrime(toLong())

fun <T : Number> T.isPermutationOf(o: T): Boolean {
    val a = toLong()
    val b = o.toLong()
    if(a.length() != b.length()) return false
    val digits = Array(10) { 0 }
    a.digits().forEach { digits[it.toInt()]++ }
    b.digits().forEach { digits[it.toInt()]-- }
    return digits.all { it == 0 }
}

fun Int.digits() = toLong().digits().map { it.toInt() }.toIntArray()

fun Long.digits(): LongArray {
    val d = ArrayList<Long>()
    var n = this
    do {
        d.add(n%10)
        n /= 10
    } while(n > 0)
    return d.toLongArray().reversedArray()
}

fun Int.isPandigital(): Boolean {
    val l = length()
    if(l > 9) return false
    val indices = (0 until l).map { this[it] - 1 }
    return indices.containsAll((0 until l).toList())
}

fun IntArray.permutations(
        prefix: Long = 0,
        e: Int = size - 1,
        length: Int = size,
        mask: Int = 0
) = map { it.toLong() }
        .toLongArray()
        .permutations(prefix, e, length, mask)
        .map { it.toInt() }
        .toIntArray()

fun LongArray.permutations(
        prefix: Long = 0,
        a: Int = size - 1,
        length: Int = size,
        mask: Int = 0
): LongArray {
    val m = if(prefix == 0L) powerOfTen((size - length).coerceAtLeast(0) + 1).toInt() else mask
    if(prefix%m != 0L) return longArrayOf(prefix/(m/10))
    if(a == 0) return longArrayOf(prefix + this[0])
    var s = longArrayOf()
    for(i in 0..a) {
        val d = this[i]
        val next = prefix + powerOfTen(a)*d
        val c = count { it == d }
        var f = filter { it != d }
        repeat(c - 1) { f = f + d }
        s += f.toLongArray().permutations(next, a - 1, length, m)
    }
    return s
}
