package net.projecteuler.problems

/**
 * Generate all triangular, pentagonal and hexagonal numbers, then check each triangular after the 285th
 * for pentagonal-ity and hexagonal-ity. Stop at the first one found.
 */

private val max = 100000
private val t = Array(max, { (0.5*(it + 1)*(it + 2)).toLong() })
private val p = Array(max, { (0.5*(it + 1)*(3*(it + 1) - 1)).toLong() })
private val h = Array(max, { (it + 1)*(2*(it + 1) - 1).toLong() })

fun main(args: Array<String>) =  println(t[tph()])

private fun tph() = (285 until max).firstOrNull { h.contains(t[it]) && p.contains(t[it]) } ?: 0