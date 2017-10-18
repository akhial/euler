package net.projecteuler;

import org.junit.Assert;
import org.junit.Test;

public class _26_LongestRecurringCycleTest {

    @Test public void cycleTest() {
        Assert.assertEquals(6, net.projecteuler.problems._26_LongestRecurringCycle.cycleLength(7));
    }
}
