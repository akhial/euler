package net.projecteuler

import net.projecteuler.api.shr
import org.junit.Assert
import org.junit.Test

class _035_Test {

    @Test
    fun shr() {
        Assert.assertEquals(612345, 123456.shr())
    }
}