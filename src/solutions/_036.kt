package solutions

/**
 * Brute-force, iterate over all integers < 1000000 and check for palindrome-ity.
 * Checking for palindromes is done via standard library functions.
 */

fun main() = println(palindromes())

private fun palindromes() = (1..1000000).filter { it.toString().isPalindromic() && Integer.toBinaryString(it).isPalindromic() }.sum()

fun String.isPalindromic(): Boolean {
    val first = this.substring(0 until length/2)
    val second = this.substring((if(length%2 == 0) length/2 else length/2 + 1) until length)
    return first == second.reversed()
}