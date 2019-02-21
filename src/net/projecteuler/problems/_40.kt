package net.projecteuler.problems

/**
 * First build the 1000000 number string using a StringBuilder (take care not to use String concatenation here
 * as you will get abysmal performance due to constant allocation of new Strings).
 *
 * After that simply access indices in the string and multiply them.
 */

fun main() = println(champernowne())

private fun champernowne(): Int {
    val sb = StringBuilder()
    for(i in 1..1000000) sb.append(i)
    val s = sb.toString()
    var r = 1
    (0 until 7).map { Math.pow(10.0, it.toDouble()).toInt() }.forEach { r *= s[it - 1].toString().toInt() }
    return r
}