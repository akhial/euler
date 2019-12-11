package solutions

import java.math.BigInteger
import kotlin.math.sqrt

/**
 * Used Euler's function and the pentagonal number theorem. The recurrence for p(n) is given by:
 * p(n) = sum((-1)^(k-1))*p(n-g(k)), k in [-l, l] - {0}).
 * Where g(k) = k(3k-1)/2 and l = sqrt(24n+1)/6
 *
 * Further reading: https://en.wikipedia.org/wiki/Partition_function_(number_theory)#Recurrence_relations
 *                  https://en.wikipedia.org/wiki/Pentagonal_number_theorem
 */

private const val M = 60000
private val p = Array<BigInteger>(M + 1) { BigInteger.ZERO }

fun coinPartitions(): Int {
    p[0] = BigInteger.ONE
    return (1..M).first{ p(it).mod(1000000.toBigInteger()) == BigInteger.ZERO }
}

private fun p(n: Int): BigInteger {
    return when {
        n < 0 -> BigInteger.ZERO
        n == 0 -> BigInteger.ONE
        p[n] != BigInteger.ZERO -> p[n]
        else -> {
            var r = BigInteger.ZERO
            val l = ((sqrt(((24*n + 1).toDouble())) + 1)/6).toInt()
            for(k in (1..l)) {
                val t = p(n - g(k)) + p(n - g(-k))
                r += if(k%2 == 1) t else t.negate()
            }
            p[n] = r
            r
        }
    }
}

private fun g(k: Int) = k*(3*k - 1)/2