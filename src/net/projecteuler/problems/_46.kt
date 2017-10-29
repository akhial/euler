package net.projecteuler.problems

import net.projecteuler.api.isPrime

/**
 * First we calculate the first max composites and the first n primes < the largest composite.
 * Then we check each composite with each prime for the existence of n where: n = (c - p)/2 is a perfect square.
 *
 * We return the first composite which does not fulfill that condition.
 */

private val max = 3000

fun main(args: Array<String>) {
    println(goldbach())
}

private fun goldbach(): Int {
    val composites = arrayListOf<Int>()
    var n = 3
    for(i in 1..max) {
        do n++ while((2*n + 1).isPrime())
        composites.add(2*n + 1)
    }
    val primes = arrayListOf<Int>()
    n = 1
    for(i in 1..max) {
        if(n > composites[max - 1]) break
        do n++ while(!n.isPrime())
        primes.add(n)
    }
    for(c in composites) {
        val found = primes.any { Math.sqrt((c - it)/2.0)%1 == 0.0 }
        if(!found) return c
    }
    return 0
}