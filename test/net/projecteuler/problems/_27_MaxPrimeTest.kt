package net.projecteuler.problems

import org.junit.Assert
import org.junit.Test

class _27_MaxPrimeTest {

    @Test
    fun primesGenerated() {
        Assert.assertEquals(39, _27_MaxPrimeFormula.primesGenerated(1, 41).toLong())
        Assert.assertEquals(79, _27_MaxPrimeFormula.primesGenerated(-79, 1601).toLong())
    }
}
