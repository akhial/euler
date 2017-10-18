package net.projecteuler;

import net.projecteuler.problems._28_SpiralDiagSum;
import org.junit.Assert;
import org.junit.Test;

public class _28_SpiralSumTest {

    @Test public void spiralSumTest() {
        Assert.assertEquals(101, _28_SpiralDiagSum.spiralSum(5));
    }
}
