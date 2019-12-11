package solutions

/**
 * Explore the possibility tree recursively, the tree for 5 is:
 *                    5
 *        4      3          2      1
 *        1    2   1      2   1    1
 *                 1      1   1    1
 *                            1    1
 *                                 1
 * The branch with root 'n' has children with roots 'n' down to 1, always including 1. If traversing a branch
 * makes us exceed the current sum 's' we backtrack. This is seen with the children of root 4 in the example above, we
 * don't traverse branches 4->4 4->3 and 4->2.
 */

private const val n = 100

fun main() = println(countingSummations())

private fun countingSummations() = explore(n - 1, 0)

private fun explore(x: Int, s: Int): Int {
    var c = 0
    if(s == n)
        c++
    else
        for(i in x.coerceAtLeast(1) downTo 1)
            if(s + i <= n)
                c += explore(i, s + i)
    return c
}