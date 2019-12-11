package solutions

import math.length

/**
 * My first approach to this problem was generating all cyclic sequences by looping through values of a, b, c, d, e
 * and f from 10 to 99, then checking each time for all number types (triangle to octagon) and storing the results
 * in a 2D array. eg:
 *
 * 1: T F T T F T
 * 2: T F F T T T
 * 3: F F T T F T
 * 4: F F F T F T
 * 5: F F T F F T
 * 6: T T T T F T
 *
 * Each column represented a number type.
 * However this required checking if I could  map each type to one number.
 * Meaning I would have to find if the family of vectors formed by the boolean values of each number in each
 * column generates a basis for the vector space {0, 1}^5 (just some linear algebra things XD)
 *
 * This turned to be too much math for this simple problem so I deleted my whole solution and chose to use the
 * opposite path: starting from the number values and checking for cyclicity. Skipping the numbers whose length is
 * not 4. And that for each unordered arrangement of number types (t, s, p, h, n and o).
 *
 * Which gave this simpler albeit verbose solution.
 */

private const val max = 150
private val t = Array(max) { (0.5*(it + 1)*(it + 2)).toLong() }
private val s = Array(max) { ((it + 1)*(it + 1)).toLong() }
private val p = Array(max) { (0.5*(it + 1)*(3*(it + 1) - 1)).toLong() }
private val h = Array(max) { ((it + 1)*(2*(it + 1) - 1)).toLong() }
private val n = Array(max) { (0.5*(it + 1)*(5*(it + 1) - 3)).toLong() }
private val o = Array(max) { ((it + 1)*(3*(it + 1) - 2)).toLong() }

fun main() = println(cyclicalFigurateNumbers())

private fun cyclicalFigurateNumbers(): Long {
    val target = { i: Int ->
        when(i) {
            0 -> t
            1 -> s
            2 -> p
            3 -> h
            4 -> n
            5 -> o
            else -> t
        }
    }
    for(i in 0..5) for(a in target(i)) {
        if(a.length() != 4) continue
        for(j in (0..5) - i) for(b in target(j)) {
            if(b.length() != 4 || b/100 != a%100) continue
            for(k in ((0..5) - i) - j) for(c in target(k)) {
                if(c.length() != 4 || c/100 != b%100) continue
                for(l in (((0..5) - i) - j) - k) for(d in target(l)) {
                    if(d.length() != 4 || d/100 != c%100) continue
                    for(m in ((((0..5) - i) - j) - k) - l) for(e in target(m)) {
                        if(e.length() != 4 || e/100 != d%100) continue
                        for(n in (((((0..5) - i) - j) - k) - l) - m) for(f in target(n)) {
                            if(f.length() != 4 || f/100 != e%100 || f%100 != a/100) continue
                            return a + b + c + d + e + f
                        }
                    }
                }
            }
        }
    }
    return 0
}