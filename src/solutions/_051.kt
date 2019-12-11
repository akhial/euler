package solutions

import math.PrimeSieve
import math.isPrime
import math.length
import math.setDigit
import kotlin.math.pow

/**
 * To solve this problem I iterate over the first primes less than 'e'.. then I use this insight to find
 * the prime digit replacements:
 *
 * We can replace the following digits in a 3-digit prime..
 *      dd*  represented by 001 = 1
 *      d*d                 010 = 2
 *      d**                 011 = 3
 *      *dd                 100 = 4
 *      *d*                 101 = 5
 *      ***                 111 <-- does not give a prime because XXX mod 111 = 0 for all X
 *
 * So for all primes I increment a mask var that I convert to a binary string padded with zeroes.
 * Then for digits 0 to 9 and for each digit in the current prime.. if I find a 1 I replace the digit
 * at the current index.
 *
 * I then count the number of primes generated this way while saving the first prime generated.
 * When the count >7 (=8) I return that prime.
 */

private const val e = 125000
private val p = PrimeSieve.getSieve().getPrimes(e)

fun primeDigitReplacements(): Int {
    for(c in p) {
        val len = c.length()
        val l = 2.0.pow(len.toDouble()).toInt() - 1
        var r = 0
        for(n in 1 until l) {
            var count = 0
            for(d in 0..9) {
                var s = c
                val mask = n.toString(2).padStart(len, '0')
                for((i, b) in mask.withIndex()) {
                    if(b == '1') {
                        s = s.setDigit(i, d, len)
                    }
                }
                if(s.isPrime() && if(d == 0) s.length() == len else true) {
                    if(r == 0) r = s
                    count++
                }
            }
            if(count == 8) return r else r = 0
        }
    }
    return 0
}