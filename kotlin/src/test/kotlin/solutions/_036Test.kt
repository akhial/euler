package solutions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class _036Test {

    @Test
    fun isPalindromic() {
        assertEquals(false, "0550055".isPalindromic())
        assertEquals(true, "10001100110001".isPalindromic())
    }

}
