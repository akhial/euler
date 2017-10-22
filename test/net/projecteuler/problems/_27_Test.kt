package net.projecteuler.problems

import org.junit.Assert
import org.junit.Test

class _27_Test {

    @Test
    fun primesGenerated() {
        Assert.assertEquals(39, _27.primesGenerated(1, 41).toLong())
        Assert.assertEquals(79, _27.primesGenerated(-79, 1601).toLong())
    }
}
