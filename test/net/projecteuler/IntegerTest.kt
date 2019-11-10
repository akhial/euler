package net.projecteuler

import net.projecteuler.api.*
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
        Assert.assertEquals(100500, 100000.setDigit(3, 5))
        Assert.assertEquals(100530, 100500.setDigit(4, 3))
        Assert.assertEquals(1, 0.setDigit(0, 1))
    }

    @Test
    fun reverse() {
        Assert.assertEquals(54321, 12345.reverse())
        Assert.assertEquals(456, 654000.reverse())
    }

    @Test
    fun digits() {
        Assert.assertArrayEquals(intArrayOf(1, 2, 3, 0, 4), 12304.digits())
        Assert.assertEquals(true, 12345.hasUniqueDigits())
        Assert.assertEquals(false, 512345.hasUniqueDigits())
    }

    @Test
    fun isPermutationOf() {
        Assert.assertEquals(true, 41063625.isPermutationOf(66430125))
        Assert.assertEquals(false, 123450.isPermutationOf(54321))
        Assert.assertEquals(true, 10010000000001.isPermutationOf(10000000000011))
    }
}