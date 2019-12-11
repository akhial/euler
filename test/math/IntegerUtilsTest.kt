package math

import org.junit.Assert
import org.junit.Test

class IntegerUtilsTest {

    @Test
    fun getDigit() {
        Assert.assertEquals(1, 1232145[0])
        Assert.assertEquals(5, 1232145[10])
        Assert.assertEquals(2, 1232145[3])
    }

    @Test
    fun getLength() {
        Assert.assertEquals(5, 12345.length())
        Assert.assertEquals(1, 0.length())
        Assert.assertEquals(1, 5.length())
    }

    @Test
    fun permutations() {
        Assert.assertArrayEquals(intArrayOf(124, 142, 214, 241, 412, 421), intArrayOf(1, 2, 4).permutations())
        val permutations = longArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).permutations()
        Assert.assertEquals(true, permutations.contains(987654321))
        Assert.assertEquals(true, permutations.contains(1234567890))
        Assert.assertEquals(true, permutations.contains(9876543210))
    }

    @Test
    fun isPandigital() {
        Assert.assertEquals(false, 123455.isPandigital())
        Assert.assertEquals(true, 654321.isPandigital())
        Assert.assertEquals(false, 654921.isPandigital())
        Assert.assertEquals(false, 654021.isPandigital())
    }

    @Test
    fun setDigit() {
        Assert.assertEquals(100500, 100000.setDigit(3, 5))
        Assert.assertEquals(100530L, 100500L.setDigit(4, 3))
        Assert.assertEquals(123, 0.setDigit(0, 1, 3).setDigit(1, 2, 3).setDigit(2, 3, 3))
        Assert.assertEquals(1, 0.setDigit(0, 1))
    }

    @Test
    fun reverse() {
        Assert.assertEquals(54321, 12345.reverse())
        Assert.assertEquals(456, 654000.reverse())
    }

    @Test
    fun digits() {
        Assert.assertArrayEquals(intArrayOf(1, 2, 3, 0, 4), 12304.digits())
    }

    @Test
    fun isPermutationOf() {
        Assert.assertEquals(true, 41063625.isPermutationOf(66430125))
        Assert.assertEquals(false, 123450.isPermutationOf(54321))
        Assert.assertEquals(true, 10010000000001.isPermutationOf(10000000000011))
    }
}