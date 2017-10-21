package net.projecteuler.problems

import org.junit.Assert
import org.junit.Test

class _26_LongestRecurringCycleTest {

    @Test
    fun cycleLength() {
        Assert.assertEquals(6, _26_LongestRecurringCycle.cycleLength(7).toLong())
    }
}
