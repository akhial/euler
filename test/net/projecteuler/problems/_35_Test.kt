package net.projecteuler.problems

import net.projecteuler.api.shr
import org.junit.Assert
import org.junit.Test

class _35_Test {

    @Test
    fun shr() {
        Assert.assertEquals(612345, 123456.shr())
    }
}