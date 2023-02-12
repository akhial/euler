package math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrimeFactorsTest {

    @Test
    fun factors() {
        assertEquals(PrimeFactors(arrayListOf(Pair(3, 1), Pair(5, 1), Pair(23, 1))), PrimeFactors.of(345))
        assertEquals(PrimeFactors(arrayListOf(Pair(2, 2))), PrimeFactors.of(4))
        assertEquals(PrimeFactors(arrayListOf(Pair(2, 2), Pair(5, 1), Pair(11, 1), Pair(31, 1))), PrimeFactors.of(6820))
    }

    @Test
    fun divisors() {
        assertEquals(arrayListOf(1, 2, 4, 5, 10, 20), PrimeFactors.of(20).divisors())
    }
}
