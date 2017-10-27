package net.projecteuler.problems

import net.projecteuler.api.isPandigital
import net.projecteuler.api.reverse
import net.projecteuler.api.setDigit
import org.junit.Assert
import org.junit.Test

class IntegerTest {
    @Test
    fun isPandigital() {
        Assert.assertEquals(false, 123455.isPandigital(6))
        Assert.assertEquals(true, 654321.isPandigital(6))
        Assert.assertEquals(false, 654921.isPandigital(6))
        Assert.assertEquals(false, 654021.isPandigital(6))
    }

    @Test
    fun setDigit() {
        Assert.assertEquals(100500, 100000.setDigit(5, 3))
        Assert.assertEquals(100530, 100500.setDigit(3, 4))
        Assert.assertEquals(1, 0.setDigit(1, 0))
    }

    @Test
    fun reverse() {
        Assert.assertEquals(54321, 12345.reverse())
        Assert.assertEquals(456, 654000.reverse())
    }
}