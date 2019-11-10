package net.projecteuler

import net.projecteuler.problems.isPandigital
import org.junit.Assert
import org.junit.Test


class _038_Test {

    @Test
    fun isPandigital() {
        Assert.assertEquals(true, "987654321".isPandigital())
        Assert.assertEquals(false, "987654221".isPandigital())
    }
}