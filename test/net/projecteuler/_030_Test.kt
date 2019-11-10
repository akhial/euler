package net.projecteuler

import net.projecteuler.api.*
import org.junit.Assert
import org.junit.Test

class _030_Test {

    @Test
    fun getDigit() {
        Assert.assertEquals(1, 1232145[0])
        Assert.assertEquals(5, 1232145[10])
        Assert.assertEquals(2, 1232145[3])
    }

    @Test
    fun getLength() {
        Assert.assertEquals(5, 12345.length())
        Assert.assertEquals(1, 0.length())
        Assert.assertEquals(1, 5.length())
    }
}