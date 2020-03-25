package math

import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

class PrimeFactorsTest {

    @Test
    fun factors() {
        Assert.assertEquals(PrimeFactors(arrayListOf(Pair(3, 1), Pair(5, 1), Pair(23, 1))), PrimeFactors.of(345))
        Assert.assertEquals(PrimeFactors(arrayListOf(Pair(2, 2))), PrimeFactors.of(4))
        Assert.assertEquals(PrimeFactors(arrayListOf(Pair(2, 2), Pair(5, 1), Pair(11, 1), Pair(31, 1))), PrimeFactors.of(6820))
    }

    @Test
    fun divisors() {
        assertEquals(arrayListOf(1, 2, 4, 5, 10, 20), PrimeFactors.of(20).divisors())
    }
}
