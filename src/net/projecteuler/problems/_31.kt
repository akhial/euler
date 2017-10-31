package net.projecteuler.problems

/**
 * I had found this recursive solution two days before I finally found how to implement it.
 *
 * This is how it works: Start at 0, add the first coin and keep adding that coin until you
 * either find a combination or exceed the amount then backtrack and add the next largest coin.
 *
 * Here's an example (X: combination found, O: Too large, C1 C2 C3 means C1: # of 1s, C2: # of 2s and C3: # of 5s):
 *
 *     0 0 0
 *     0 0 1 -> X
 *     0 1 0 -> 0 2 0 -> 0 3 0 -> O
 *                    -> 1 2 0 -> X
 *           -> 1 1 0 -> 2 1 0 -> 3 1 0 -> X
 *     1 0 0 -> 2 0 0 -> 3 0 0 -> 4 0 0 -> 5 0 0 -> X
 */

val coins = intArrayOf(1, 2, 5, 10, 20, 50, 100, 200)
val amount = 200

fun main(args: Array<String>) = println(combinationsOf())

private fun combinationsOf(addend: Int = coins.size - 1, current: Int = 0): Int {
    if(current == amount) return 1
    if(current > amount || addend < 0) return 0

    return combinationsOf(addend, current + coins[addend]) + combinationsOf(addend - 1, current)
}
