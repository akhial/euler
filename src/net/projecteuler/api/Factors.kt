package net.projecteuler.api

import kotlin.math.pow

class Factors(val factors: ArrayList<Pair<Int, Int>>) {
    companion object {
        private val primeSieve = PrimeSieve.getSieve()
        private var primes = primeSieve.getPrimes(100)

        fun getPrimes(n: Int) = primeSieve.getPrimes(n)

        fun of(n: Int): Factors {
            val f = arrayListOf<Pair<Int, Int>>()

            if(n == 0) return Factors(f)
            if(n.isPrime()) {
                f.add(Pair(n, 1))
                return Factors(f)
            }

            if(n > primes.last()*primes.last())
                primes = primeSieve.getPrimes(n)

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

    fun value() = factors.map { it.first.toDouble().pow(it.second.toDouble()).toInt() }.reduce { t, x -> t*x }

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