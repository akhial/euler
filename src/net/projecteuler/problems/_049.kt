package net.projecteuler.problems

import net.projecteuler.math.digits
import net.projecteuler.math.isPrime
import net.projecteuler.math.length
import net.projecteuler.math.permutations

/**
 * For the odd numbers p between 10000 and 1000 non-inclusive, we check every possible arithmetic progression
 * of 3 elements p r s to find whether or not all it's elements are prime and superior in length to 4.
 *
 * Stop at the first progression found.
 */

fun main() = println(primePermutations())

private fun primePermutations(): String {
    for(q in 5000 downTo 500) {
        val p = 2*q + 1
        for(i in 2..3330) {
            val r = p - i
            val s = p - 2*i
            if(r.length() < 4 || s.length() < 4) continue
            if(p.isPrime() && r.isPrime() && s.isPrime()) {
                val c = p.digits().permutations()
                if(c.contains(r) && c.contains(s)) return "$s$r$p"
            }
        }
    }
    return ""
}