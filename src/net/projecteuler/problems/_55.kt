package net.projecteuler.problems

import net.projecteuler.api.reverse

/**
 * While we haven't done 50 iterations add to the current n it's reverse and check it it's palindromic,
 * if not keep going.
 * Check if we stopped because we found a palindrome or because of iterations.. if its the latter inc count.
 */

fun main(args: Array<String>) = println(lychrelNumbers())

private fun lychrelNumbers(): Int {
    var c = 0
    for(n in 1 until 10000) {
        var lychrel = true
        var i = 0
        var r = n.toLong()
        while(lychrel && i < 50) {
            r += r.reverse()
            lychrel = !r.toString().isPalindromic()
            i++
        }
        if(lychrel) c++
    }
    return c
}

