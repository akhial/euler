package solutions

import math.isqrt

/**
 * By unfolding an AxBxC cuboid we find that the shortest distance to the fly is always sqrt(A^2 + (B + C)^2)
 * when A>=B>=C.
 * So for each m = A we check all possible sums x = B + C where x is in [2; 2A], because B <= A && C <= A implies
 * B + C <= 2A.
 * For each x check if the shortest distance is an integer. Then add the number of valid combinations of B and C giving
 * that sum to the total integer-distance-cuboid count.
 *
 * If x <= A, the number of valid combinations is equal to the total number of combinations (B, C) satisfying B + C = x
 * minus the number of combinations where B < C.
 * Eg: If B + C = 6.
 * The total number of combinations is B + C - 1 = 5 and they are: (5, 1), (4, 2), (3, 3), (2, 4) and (1, 5).
 * The number of combinations where B < C is (B + C)/2 - 1 and they are: (2, 4), (1, 5).
 * The number of valid combinations is B + C - 1 - ((B + C)/2 - 1) = (B + C)/2 and they are (5, 1), (4, 2) and (3, 3).
 *
 * If x > A the number of valid combinations is equal to the number of combinations found using the method above minus
 * the number of combinations where B > A.
 * Eg: If B + C = 6 and A = 4.
 * The number of valid combinations without the A bound is (B + C)/2 = 3 and they are (5, 1), (4, 2) and (3, 3).
 * The number of combinations that with B > A is B + C - 1 - A.
 * The number of valid combinations is (B + C)/2 - (B + C - 1 - A) = A + 1 - (B + C)/2 and they are (4, 2) and (3, 3).
 */

fun cuboidRoute(): Int {
    var c = 0
    var m = 2
    while(c < 1_000_000) {
        for(x in 2..2*m) {
            val p = m*m + x*x
            val isqrt = isqrt(p)
            if(isqrt*isqrt == p) c += if(x <= m) x/2 else m + 1 - x/2
        }
        m++
    }
    return m
}
