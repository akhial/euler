package net.projecteuler.api

/**
 * Represents the prime factors of an integer.
 */
class Factors(private val factors: ArrayList<Pair<Int, Int>>) {
    /**
     * Allows getting the prime factors of an int, the initial prime array contains 1000 primes.
     * When the argument is larger than the largest prime we increase the prime count by a factor of 1,5.
     *
     * Using an eratosthenes sieve will yield better performance.
     */
    companion object {
        val ZERO = Factors(arrayListOf())
        private var max = 1000
        private var primes = getPrimes(max)

        fun getPrimes(len: Int, prev: ArrayList<Int> = arrayListOf(2)): ArrayList<Int> {
            var q = (prev.last() - 1)/2
            for(i in 1..len) {
                do q++ while(!(2*q + 1).isPrime())
                prev.add(2*q + 1)
            }
            return prev
        }

        fun of(n: Int): Factors {
            if(n == 0) return ZERO

            val f = arrayListOf<Pair<Int, Int>>()
            var r = n
            while(n > primes.last()) {
                max += max/2
                primes = getPrimes(max, primes)
            }
            var i = 0
            while(r != 1) {
                val p = primes[i]
                var c = 0
                while(r%p == 0) {
                    r /= p
                    c++
                }
                if(c != 0) f.add(Pair(p, c))
                i++
            }
            return Factors(f)
        }
    }

    /**
     * Calculates the value of the factors in [factors].
     */
    fun value(): Int = factors.map { Math.pow(it.first.toDouble(), it.second.toDouble()).toInt() }
            .reduce({ t, x -> t*x })

    /**
     * Returns the number of factors.
     */
    fun count(): Int = factors.count()
}