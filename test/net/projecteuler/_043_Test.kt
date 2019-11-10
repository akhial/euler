package net.projecteuler

import net.projecteuler.api.permutations
import org.junit.Assert
import org.junit.Test

class _043_Test {

    private val digits = longArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    @Test
    fun permutations() {
        val permutations = digits.permutations()
        Assert.assertEquals(true, permutations.contains(987654321))
        Assert.assertEquals(true, permutations.contains(1234567890))
        Assert.assertEquals(true, permutations.contains(9876543210))
    }
}