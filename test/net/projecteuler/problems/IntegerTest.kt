package net.projecteuler.problems

import net.projecteuler.api.isPandigital
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
}