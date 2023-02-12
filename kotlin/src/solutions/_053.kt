package solutions

import math.bigFact
import java.math.BigInteger

/**
 * Use [BigInteger].
 */

fun combinatoricSelections() = (1..100).sumBy { n ->
    (0 until 100).count { k -> nck(n, k) > BigInteger.valueOf(1000000) }
}

private fun nck(n: Int, k: Int): BigInteger {
    if(k > n) return BigInteger.ZERO
    return bigFact(n)/(bigFact(k)*bigFact(n - k))
}
