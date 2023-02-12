package solutions

import math.fact
import math.get
import math.length

/**
 * Brute-force, the limit of 50000 was found through trial and error.
 */

fun digitFactorials(): Int {
    var result = 0
    for(n in 3..50000) {
        val sum = (0 until n.length()).sumOf { fact(n[it]).toInt() }
        if(sum == n) result += n
    }
    return result
}
