package net.projecteuler.problems

import org.junit.Assert
import org.junit.Test

class _26_Test {

    @Test
    fun cycleLength() {
        Assert.assertEquals(6, _26.cycleLength(7).toLong())
    }
}
