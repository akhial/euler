package math

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntegerUtilsTest {

    @Test
    fun getDigit() {
        assertEquals(1, 1232145[0])
        assertEquals(5, 1232145[10])
        assertEquals(2, 1232145[3])
    }

    @Test
    fun getLength() {
        assertEquals(5, 12345.length())
        assertEquals(1, 0.length())
        assertEquals(1, 5.length())
    }

    @Test
    fun permutations() {
        assertArrayEquals(intArrayOf(124, 142, 214, 241, 412, 421), intArrayOf(1, 2, 4).permutations())
        val permutations = longArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).permutations()
        assertEquals(true, permutations.contains(987654321))
        assertEquals(true, permutations.contains(1234567890))
        assertEquals(true, permutations.contains(9876543210))
    }

    @Test
    fun isPandigital() {
        assertEquals(false, 123455.isPandigital())
        assertEquals(true, 654321.isPandigital())
        assertEquals(false, 654921.isPandigital())
        assertEquals(false, 654021.isPandigital())
    }

    @Test
    fun setDigit() {
        assertEquals(100500, 100000.setDigit(3, 5))
        assertEquals(100530L, 100500L.setDigit(4, 3))
        assertEquals(123, 0.setDigit(0, 1, 3).setDigit(1, 2, 3).setDigit(2, 3, 3))
        assertEquals(1, 0.setDigit(0, 1))
    }

    @Test
    fun reverse() {
        assertEquals(54321, 12345.reverse())
        assertEquals(456, 654000.reverse())
    }

    @Test
    fun digits() {
        assertArrayEquals(intArrayOf(1, 2, 3, 0, 4), 12304.digits())
    }

    @Test
    fun isPermutationOf() {
        assertEquals(true, 41063625.isPermutationOf(66430125))
        assertEquals(false, 123450.isPermutationOf(54321))
        assertEquals(true, 10010000000001.isPermutationOf(10000000000011))
    }

    @Test
    fun isqrt() {
        assertEquals(5, isqrt(27))
        assertEquals(10, isqrt(101))
        assertEquals(2, isqrt(6))
        assertEquals(1, isqrt(3))
        assertEquals(2, isqrt(8))
    }

    @Test
    fun gcd() {
        assertEquals(5, gcd(5, 25))
        assertEquals(17, gcd(17*25, 17*103))
    }

}
