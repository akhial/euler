package net.projecteuler

import net.projecteuler.problems._026
import org.junit.Assert
import org.junit.Test

class _026_Test {

    @Test
    fun cycleLength() {
        Assert.assertEquals(6, _026.cycleLength(7).toLong())
    }
}
