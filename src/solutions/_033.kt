package solutions

import math.gcd
import math.get

/**
 * A brute-force method, we check if the number have a digit in common (ignoring trivial cases),
 * if they do check the quotient of the two numbers and the quotient of the two numbers without the digits in common.
 */

fun digitCancellingFractions(): Int {
    var productA = 1
    var productB = 1
    for(a in 11..100) {
        for(b in 11..100) {
            if(a.toDouble()/b == rdQuotient(a, b)) {
                productA *= a
                productB *= b
            }
        }
    }
    return productB/gcd(productA, productB)
}

private fun rdQuotient(a: Int, b: Int): Double {
    return when {
        a > b -> 0.0
        a == b -> 0.0
        a%10 == 0 || b%10 == 0 -> 0.0
        a[0] == b[0] -> a[1].toDouble()/b[1]
        a[0] == b[1] -> a[1].toDouble()/b[0]
        a[1] == b[0] -> a[0].toDouble()/b[1]
        a[1] == b[1] -> a[0].toDouble()/b[0]
        else -> 0.0
    }
}