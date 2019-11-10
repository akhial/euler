package net.projecteuler

import net.projecteuler.api.Factors
import org.junit.Assert
import org.junit.Test


class FactorsTest {

    @Test
    fun factors() {
        Assert.assertEquals(Factors(arrayListOf(Pair(3, 1), Pair(5, 1), Pair(23, 1))), Factors.of(345))
        Assert.assertEquals(Factors(arrayListOf(Pair(2, 2), Pair(5, 1), Pair(11, 1), Pair(31, 1))), Factors.of(6820))
        Assert.assertEquals(11492, Factors.of(11492).value())
    }
}