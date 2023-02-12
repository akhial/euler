package solutions

import math.digits
import math.permutations

/**
 * Indices used in the array 'v':
 *      (0)
 *         \
 *          (1)     (2)
 *        /     \  /
 *     (9)      (3)
 *    /   \     /
 * (8)    (7)-(5)-(4)
 *          \
 *          (6)
 *
 * Brute-force, take all permutations of the numbers 0 through 9. Then fill the values array 'v' with each and check if
 * the permutation gives a solution using the indices above. The 0 is replaced with a 10 in 'v' @ lines 36-43.
 * To do so, add the values in indices 0, 1, 3; 2, 3, 5; ... and check if the sums are equal.
 * If it is a solution calculate the according representation, then check if it has 16 digits. If that is the case,
 * update the max value.
 */

fun magic5GonRing(): Long {
    val m = 10000000000000000L
    var max = 0L
    var v: LongArray
    val p = 1234567890L.digits().permutations()

    for(k in 0..3628799) {
        v = p[k].digits()

        val i = v.indexOf(0)
        if(i > -1) v[i] = 10
        else {
            val s = v[8]
            for(j in 8 downTo 1) v[j] = v[j - 1]
            v = v.plus(s)
            v[0] = 10
        }

        val base = v[0] + v[1] + v[3]
        var b = true
        for(n in 1..4) {
            val c = n*2
            if(v[c] + v[c + 1] + v[(c + 3)%10] != base) {
                b = false
                break
            }
        }

        if(b) {
            val uniqueID = v.getUniqueID()
            if(uniqueID in max..m) max = uniqueID
        }
    }
    return max
}

private fun LongArray.getUniqueID(): Long {
    val min = this.filterIndexed { index, _ -> index%2 == 0 }.min()
    var c = this.indexOf(min)

    val sb = StringBuilder()

    for(i in 0..4) {
        sb.append("${this[c%10]}${this[(c + 1)%10]}${this[(c + 3)%10]}")
        c += 2
    }

    return sb.toString().toLong()
}
