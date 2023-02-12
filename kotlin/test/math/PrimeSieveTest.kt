package math

import org.junit.Test
import kotlin.test.assertEquals

class PrimeSieveTest {

    @Test
    fun isPrime() {
        PrimeSieve.getSieve().reset()
        assertEquals(10000007.isPrime(), PrimeSieve.getSieve().isPrime(10000007))
        PrimeSieve.getSieve().reset()
        PrimeSieve.getSieve().sieve(80000)
        assertEquals(false, PrimeSieve.getSieve().isPrime(4))
    }

    @Test
    fun primeCheck() {
        fun getPrimes(x: Int) = (2..x).filter { it.isPrime() }.toList()
        PrimeSieve.getSieve().reset()
        var l = 1000
        assertEquals(getPrimes(l), PrimeSieve.getSieve().getPrimes(l))
        l = 500
        assertEquals(getPrimes(l), PrimeSieve.getSieve().getPrimes(l))
        l = 250
        assertEquals(getPrimes(l), PrimeSieve.getSieve().getPrimes(l))
        l = 125000
        assertEquals(getPrimes(l), PrimeSieve.getSieve().getPrimes(l))
        l = 200000
        PrimeSieve.getSieve().sieve(l)
        assert(getPrimes(l).all { PrimeSieve.getSieve().isPrime(it) })
    }

    @Test
    fun allArePrimes() {
        PrimeSieve.getSieve().reset()
        assert(PrimeSieve.getSieve().getPrimes(10000).all { it.isPrime() })
        assert(PrimeSieve.getSieve().getPrimes(10001).all { it.isPrime() })
        assert(PrimeSieve.getSieve().getPrimes(130000).all { it.isPrime() })
        assert(PrimeSieve.getSieve().getPrimes(125000).all { it.isPrime() })
    }
}
