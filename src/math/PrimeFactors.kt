package math

import kotlin.math.pow

class PrimeFactors(val factors: ArrayList<Pair<Int, Int>>) {
    companion object {
        private var max = 0
        private var primes = arrayListOf(0)

        fun init(n: Int) {
            PrimeSieve.getSieve().sieve(n)
            primes = PrimeSieve.getSieve().getPrimes(isqrt(n))
            max = n
        }

        fun of(n: Int): PrimeFactors {
            if(n < 0) {
                throw IllegalArgumentException("factor of negative number")
            }
            if(n == 0) {
                return PrimeFactors(arrayListOf())
            }
            if(n < max && PrimeSieve.getSieve().isPrime(n) || n.isPrime()) {
                return PrimeFactors(arrayListOf(Pair(n, 1)))
            }
            if(n > primes.last().toLong()*primes.last()) {
                primes = PrimeSieve.getSieve().getPrimes(2*isqrt(n))
            }
            var i = 0
            var remainder = n
            var remainderIsPrime = false
            val factors = arrayListOf<Pair<Int, Int>>()
            while(i < primes.size && remainder != 1 && !remainderIsPrime) {
                val prime = primes[i]
                var exponent = 0
                while(remainder%prime == 0) {
                    remainder /= prime
                    exponent++
                }
                if(exponent != 0) {
                    factors.add(Pair(prime, exponent))
                }
                if(PrimeSieve.getSieve().isPrime(remainder)) {
                    remainderIsPrime = true
                }
                i++
            }
            if(remainderIsPrime) {
                factors.add(Pair(remainder, 1))
            }
            return PrimeFactors(factors)
        }
    }

    fun divisors(): List<Int> {
        val exponents = IntArray(factors.size)
        val divisors = mutableListOf<Int>()
        while(true) {
            val divisor = factors
                    .mapIndexed { index, factor -> factor.first.toDouble().pow(exponents[index]).toInt() }
                    .reduce { product, factor -> product*factor }
            divisors.add(divisor)
            var i = 0
            while(true) {
                exponents[i]++
                if(exponents[i] <= factors[i].second) {
                    break
                }
                exponents[i] = 0
                i++
                if(i >= factors.size) {
                    return divisors
                }
            }
        }
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
