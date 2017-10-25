package net.projecteuler.problems

import net.projecteuler.api.permutations
import org.junit.Assert
import org.junit.Test


class _32_Test {

    @Test
    fun permutations() {
        Assert.assertArrayEquals(intArrayOf(124, 142, 214, 241, 412, 421), intArrayOf(1, 2, 4).permutations())
    }
}