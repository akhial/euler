package net.projecteuler.problems

import net.projecteuler.math.digits
import net.projecteuler.math.get
import net.projecteuler.math.length
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

/**
 * Dumbest solution ever lol. Started at 70000000 because 7 is before all other digits and there has to be
 * at least 8 digits in the number.
 */

fun main() = println(passcodeDerivation())

private fun passcodeDerivation(): Int {
    val l = Files.lines(Paths.get("res/p079_keylog.txt")).sorted().distinct().toList()
    for(i in 70000000..100000000) {
        val d = i.digits()
        if(d.any { it == 4 || it == 5 }) continue
        if(0 !in d || 1 !in d || 2 !in d || 3 !in d || 6 !in d || 7 !in d || 8 !in d || 9 !in d) continue
        if(check(i, l)) return i
    }
    return 0
}

private fun check(n: Int, l: Iterable<String>): Boolean {
    var f = true
    for(w in l) {
        var i = 0
        for(c in w) {
            while(i < n.length() && Character.getNumericValue(c) != n[i]) i++
            if(i == n.length()) f = false
        }
    }
    return f
}