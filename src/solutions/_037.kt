package solutions

import math.isPrime
import math.length
import kotlin.math.pow

/**
 * To remove digits from the right divide by 10, to remove digits from the left you have to find the remainder mod
 * the length of the number - 1.
 * The rest is just iteration and checking.
 */

fun main() = println(truncateCount())

private fun truncateCount(): Int {
    var count = 0
    var n = 11
    var sum = 0
    while(count < 11) {
        if(n.isPrime()) {
            var l = n
            var r = n
            var truncate = true
            while(l > 0 && truncate) {
                truncate = l.isPrime()
                l /= 10
            }
            while(r > 0 && truncate) {
                truncate = r.isPrime()
                r %= 10.0.pow(r.length().toDouble() - 1).toInt()
            }
            if(truncate) {
                sum += n
                count++
            }
        }
        n++
    }
    return sum
}