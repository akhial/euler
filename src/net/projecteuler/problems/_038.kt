package net.projecteuler.problems

/**
 * The limit for n is 10000 because 1*10000+2*10000 contains 10 digits so it can't be 9-pandigital.
 *
 * We iterate over all n < 10000 and concatenate the successive multiplication results to a string,
 * we then check if the string is pandigital and larger than the old maximum, if it is we store it as
 * the new max.
 */

fun main() = println(pandigitalMultiple())

private fun pandigitalMultiple(): Int {
    var max = 0
    for(n in 1..10000) {
        var s = ""
        var m = 1
        while(s.length < 9) {
            s = s.plus(n*m)
            m++
        }
        val c = if(s.length < 10) s.toInt() else 0
        if(s.isPandigital() && c > max) max = c
    }
    return max
}

fun String.isPandigital(): Boolean {
    if(length != 9) return false
    return toList().containsAll(('1'..'9').toList())
}