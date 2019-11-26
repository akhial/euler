package net.projecteuler.api

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Represents the prime factors of an integer.
 */
class Factors(val factors: ArrayList<Pair<Int, Int>>) {
    /**
     * Allows getting the prime factors of an integer.
     */
    companion object {
        fun getPrimes(n: Int): ArrayList<Int> {
            return Eratosthenes.sieve(n)
        }

        fun of(n: Int): Factors {
            val f = arrayListOf<Pair<Int, Int>>()

            if(n == 0) return Factors(f)
            if(n.isPrime()) {
                f.add(Pair(n, 1))
                return Factors(f)
            }

            val primes = Eratosthenes.sieve(sqrt(n.toDouble()).toInt() + 1)

            var r = n
            var i = 0
            var s = false
            while(r != 1 && !s) {
                val p = primes[i]
                var c = 0
                while(r%p == 0) {
                    r /= p
                    c++
                }
                if(c != 0) {
                    f.add(Pair(p, c))
                    if(r.isPrime()) s = true
                }
                i++
            }
            if(s) f.add(Pair(r, 1))
            return Factors(f)
        }
    }

    /**
     * Calculates the value of the factors in [factors].
     */
    fun value() = factors.map { it.first.toDouble().pow(it.second.toDouble()).toInt() }.reduce { t, x -> t*x }

    /**
     * Returns the number of factors.
     */
    fun count() = factors.count()

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(javaClass != other?.javaClass) return false

        other as Factors

        if(!factors.containsAll(other.factors)) return false

        return true
    }

    override fun hashCode(): Int = factors.hashCode()

    override fun toString(): String = factors.toString()
}