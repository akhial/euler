package solutions

import math.PrimeUtils
import math.isPrime
import math.length
import math.powerOfTen

/**
 * Brute-force, to check for circularity I shift the prime continuously to the right "length" times.
 * Checking if its prime each time.
 *
 * @see [PrimeUtils.isPrime].
 */

fun circularPrimes(): Int {
    var count = 0
    for(n in 1 until 1000000) {
        if(n.isPrime()) {
            var prime = n
            var isCircular = true
            var j = 0
            while(isCircular && j < prime.length()) {
                prime = prime.dshr()
                isCircular = prime.isPrime()
                j++
            }
            if(isCircular) count++
        }
    }
    return count
}

private fun Int.dshr() = ((this%10)*powerOfTen(length() - 1) + this/10).toInt()
