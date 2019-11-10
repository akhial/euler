package net.projecteuler

import net.projecteuler.problems.isPalindromic
import org.junit.Assert
import org.junit.Test


class _036_Test {

    @Test
    fun isPalindromic() {
        Assert.assertEquals(false, "0550055".isPalindromic())
        Assert.assertEquals(true, "10001100110001".isPalindromic())
    }
}