package net.projecteuler.problems

import org.junit.Assert
import org.junit.Test

class _28_SpiralSumTest {

    @Test fun spiralSum() {
        Assert.assertEquals(101, spiralSum(5).toLong())
    }
}
