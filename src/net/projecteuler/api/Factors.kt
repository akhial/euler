package net.projecteuler.api

/**
 * Represents the prime factors of an integer.
 */
class Factors(private val factors: ArrayList<Pair<Int, Int>>) {
    /**
     * Allows getting the prime factors of an int, the initial prime array contains 1000 primes.
     * When the argument is larger than 2 times the largest prime we increase the prime count by a factor of 1,5.
     *
     * Using an eratosthenes sieve will yield better performance.
     */
    companion object {
        val ZERO = Factors(arrayListOf())
        var max = 10000
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
            while(n > 2*primes.last()) {
                primes = getPrimes(max/2, primes)
                max += max/2
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
    fun value() = factors.map { Math.pow(it.first.toDouble(), it.second.toDouble()).toInt() }.reduce { t, x -> t*x }

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