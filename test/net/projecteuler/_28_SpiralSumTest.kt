package net.projecteuler

import net.projecteuler.problems.*
import org.junit.Assert
import org.junit.Test

class _28_SpiralSumTest {

    @Test fun spiralSumTest() {
        Assert.assertEquals(101, spiralSum(5).toLong())
    }
}
