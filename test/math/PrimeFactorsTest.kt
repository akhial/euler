package math

import org.junit.Assert
import org.junit.Test

class PrimeFactorsTest {

    @Test
    fun factors() {
        Assert.assertEquals(PrimeFactors(arrayListOf(Pair(3, 1), Pair(5, 1), Pair(23, 1))), PrimeFactors.of(345))
        Assert.assertEquals(PrimeFactors(arrayListOf(Pair(2, 2), Pair(5, 1), Pair(11, 1), Pair(31, 1))), PrimeFactors.of(6820))
        Assert.assertEquals(11492, PrimeFactors.of(11492).value())
    }
}