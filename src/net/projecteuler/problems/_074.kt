package net.projecteuler.problems

import net.projecteuler.api.Factorial.factorial
import net.projecteuler.api.digits

/**
 * Uses floyd's cycle detection algorithm (or tortoise and hare algorithm) to find cycles. Much like in Pollard's rho
 * algorithm for prime factorization.
 *
 * Further reading: https://en.wikipedia.org/wiki/Cycle_detection
 */

private val fact = Array(10) { factorial(it) }

fun main() = println(digitFactorialChains())

private fun digitFactorialChains(): Int = (1..1000000L).filter { floyd(it, ::g) == 60 }.count()

fun floyd(n: Long, f: (Long) -> Long): Int {
    var t = f(n) // tortoise
    var h = f(f(n)) // hare

    while(t != h) {
        t = f(t)
        h = f(f(h))
    }

    var s = 0
    t = n
    while(t != h) {
        t = f(t)
        h = f(h)
        s++
    }

    var l = 1
    h = f(t)
    while(t != h) {
        h = f(h)
        l++
    }

    return s + l
}

private fun g(n: Long): Long = n.digits().map { fact[it.toInt()] }.sum()