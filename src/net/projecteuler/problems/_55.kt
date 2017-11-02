package net.projecteuler.problems

import net.projecteuler.api.reverse

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

