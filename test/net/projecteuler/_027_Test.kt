package net.projecteuler

import net.projecteuler.problems._027
import org.junit.Assert
import org.junit.Test

class _027_Test {

    @Test
    fun primesGenerated() {
        Assert.assertEquals(39, _027.primesGenerated(1, 41).toLong())
        Assert.assertEquals(79, _027.primesGenerated(-79, 1601).toLong())
    }
}
