package math

import kotlin.math.pow

private var max = 0

class PrimeFactors(val factors: ArrayList<Pair<Int, Int>>) : Iterable<Pair<Int, Int>> {
    companion object {
        private var primes = arrayListOf(0)

        fun init(n: Int) {
            PrimeSieve.getSieve().sieve(n)
            primes = PrimeSieve.getSieve().getPrimes(isqrt(n))
            max = n
        }

        fun of(n: Int): PrimeFactors {
            val f = arrayListOf<Pair<Int, Int>>()
            if(n == 0) return PrimeFactors(f)

            if(n < max && PrimeSieve.getSieve().isPrime(n)) {
                return PrimeFactors(arrayListOf(Pair(n, 1)))
            } else if(n.isPrime()) {
                return PrimeFactors(arrayListOf(Pair(n, 1)))
            }

            val l = primes.last().toLong()
            if(n > l*l) primes = PrimeSieve.getSieve().getPrimes(2*isqrt(n))

            var r = n
            var i = 0
            var s = false
            while(i < primes.size && r != 1 && !s) {
                val p = primes[i]
                var c = 0
                while(r%p == 0) {
                    r /= p
                    c++
                }
                if(c != 0) {
                    f.add(Pair(p, c))
                }
                if(PrimeSieve.getSieve().isPrime(r)) s = true
                i++
            }
            if(s) f.add(Pair(r, 1))
            return PrimeFactors(f)
        }
    }

    fun count() = factors.count()

    fun value() = factors.map { it.first.toDouble().pow(it.second.toDouble()).toInt() }.reduce { t, x -> t*x }

    override fun iterator(): Iterator<Pair<Int, Int>> {
        return factors.iterator()
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(javaClass != other?.javaClass) return false

        other as PrimeFactors

        if(!factors.containsAll(other.factors)) return false

        return true
    }

    override fun hashCode(): Int = factors.hashCode()

    override fun toString(): String = factors.toString()
}