package net.projecteuler

import net.projecteuler.problems._27_MaxPrimeFormula
import org.junit.Assert
import org.junit.Test

class _27_MaxPrimeTest {

    @Test fun primesGeneratedTest() {
        Assert.assertEquals(39, _27_MaxPrimeFormula.primesGenerated(1, 41).toLong())
        Assert.assertEquals(79, _27_MaxPrimeFormula.primesGenerated(-79, 1601).toLong())
    }
}
