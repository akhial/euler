package math

import kotlin.math.pow

class PrimeFactors(val factors: ArrayList<Pair<Int, Int>>): Iterable<Pair<Int, Int>> {
    companion object {
        private var primes = PrimeSieve.getSieve().getPrimes(1000)

        fun of(n: Int): PrimeFactors {
            val f = arrayListOf<Pair<Int, Int>>()

            if(n == 0) return PrimeFactors(f)
            if(n.isPrime()) {
                f.add(Pair(n, 1))
                return PrimeFactors(f)
            }

            val l = primes.last()
            if(n > l*l)
                primes = PrimeSieve.getSieve().getPrimes(2*l)

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
                    if(PrimeSieve.getSieve().isPrime(r)) s = true
                }
                i++
            }
            if(s) f.add(Pair(r, 1))
            return PrimeFactors(f)
        }
    }

    fun value() = factors.map { it.first.toDouble().pow(it.second.toDouble()).toInt() }.reduce { t, x -> t*x }

    fun count() = factors.count()

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