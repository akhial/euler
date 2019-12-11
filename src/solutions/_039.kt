package solutions

/**
 * Iterate over all triplets (a, b, c) where a <= b < c because c is the hypotenuse.
 * When we find a solution that fulfills the pythagoras theorem (a^2 + b^2 = c^2) then we increment
 * the number of solutions.
 *
 * When we find a new max we set it to the max and the result to p.
 */

fun integerRightTriangles(): Int {
    var max = 0
    var r = 0
    for(p in 1 until 1000) {
        var s = 0
        for(a in 1 until p - 1) {
            for(b in a until (p - a)/2) {
                val c = p - a - b
                if(a*a + b*b == c*c) s++
            }
        }
        if(s > max) {
            max = s
            r = p
        }
    }
    return r
}