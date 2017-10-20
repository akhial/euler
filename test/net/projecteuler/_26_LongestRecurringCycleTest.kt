package net.projecteuler

import org.junit.Assert
import org.junit.Test

class _26_LongestRecurringCycleTest {

    @Test fun cycleTest() {
        Assert.assertEquals(6, net.projecteuler.problems._26_LongestRecurringCycle.cycleLength(7).toLong())
    }
}
