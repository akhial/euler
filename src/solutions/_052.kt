package solutions

import math.digits
import math.permutations

/**
 * For every n, check the products of n and 2 to 6 for whether they are contained in the permutations of n.
 * Return the first one found.
 */

fun permutedMultiples(): Int {
    for(n in 125874..1000000) {
        val p = n.digits().permutations()
        var f = true
        var m = 2
        while(m <= 6 && f) {
            f = p.contains(n*m)
            m++
        }
        if(f) return n
    }
    return 0
}
