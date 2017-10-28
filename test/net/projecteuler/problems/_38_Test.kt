package net.projecteuler.problems

import org.junit.Assert
import org.junit.Test


class _38_Test {

    @Test
    fun isPandigital() {
        Assert.assertEquals(true, "987654321".isPandigital())
        Assert.assertEquals(false, "987654221".isPandigital())
    }
}