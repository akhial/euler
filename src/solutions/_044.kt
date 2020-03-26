package solutions

import kotlin.math.floor
import kotlin.math.sqrt

/**
 * The minimal distance occurs in the first solution found when iterating in order.
 * Just iterate over the pentagonal numbers while checking the sum and difference for pentagonal-ity.
 *
 * A number is pentagonal if it can be written in the form n = 0.5(x + 1)(3(x + 1) - 1), so we check if the quadratic
 * equation 3x² + 5x + 2 - 2n = 0 has an integer positive solution.
 * The positive solution is x = (-b + sqrt(b² - 4ac))/2a = (-5 + sqrt(25 - 12*(2 - 2*n)))/6.
 */

private const val max = 2200
private val p = IntArray(max) { (it + 1)*(3*(it + 1) - 1)/2 }

fun pentagonNumbers(): Int {
    for(j in 1 until max)
        for(k in j until max)
            if(isP(p[j] + p[k]) && isP(p[k] - p[j]))
                return p[k] - p[j]
    return 0
}

private fun isP(n: Int): Boolean {
    val x = (-5 + sqrt((25 - 12*(2 - 2*n)).toDouble()))/6
    return x == floor(x)
}
