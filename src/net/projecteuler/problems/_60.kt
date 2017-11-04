package net.projecteuler.problems

import net.projecteuler.api.Factors
import net.projecteuler.api.isPrime

/**
 * Optimisation? Hell yeah..
 *
 * Initially this solution would've taken a quite few hours to run... Mostly because I started off the wrong idea.
 * But I found the optimisation process very enjoyable for this problem and wanted to share it:
 *
 * My first approach was this O(n^5) solution:
 *
 *     for(a in primes)
 *         for(b in primes)
 *             ...
 *             for(e in primes) { fill an array with the 20 possible concatenations and test each one }
 *
 * For n = 100 this ran in about 20s, so to finish running for the 1000 primes required it would take 10000 times
 * longer... about 56 hours.
 *
 * My next optimisation was to only calculate the combinations if we hadn't already met the escape condition..
 * essentially including the concatenations inside a while loop.
 *
 *     for(a in primes)
 *         for(b in primes)
 *             ...
 *             for(e in primes) { While the current concatenated potential prime is prime..
 *                 find and test the next one }
 *
 * Then I changed my loops to only check for quintuplets of ascending primes..
 *
 *     for(i in 1..max-4)
 *         for(j in i..max-3)
 *             ...
 *             for(m in l..max) { Same thing }
 *
 * All of these attempts still didn't allow reasonable run times, the insight that allowed me to solve this problem was
 * figuring out that most of the time I get to the last e loop with primes that don't even work for only a and b.
 * The solution was testing the combinations as soon as I get into each loop, and skipping the primes that don't work.
 *
 *     for(j in 1..max-3) {
 *         Test a.b and b.a
 *         If one isn't prime skip current b
 *         for(k in i..max-2) {
 *             Test c.a c.b a.c b.c
 *             If one isn't prime skip current c
 *             ...
 *
 *         }
 *     }
 *
 * Which gave the final result below, it currently runs in about a second on my machine. While I could have found
 * a simpler solution, sticking with my first attempt paid off.
 */

private val max = 1050
private val primes = Factors.getPrimes(max)
private val check = HashMap<Long, Boolean>()

fun main(args: Array<String>) = println(primePairSets())

private fun primePairSets(): Int {
    val isPrime = { v: Long ->
        check[v] ?: {
            val r = v.isPrime()
            check[v] = r
            r
        }()
    }

    for(i in 1 until max - 3) {
        var f: Boolean
        var n: Int
        val a = primes[i]
        for(j in i + 1 until max - 2) {
            f = true
            n = 0
            val b = primes[j]

            while(f && n < 2) {
                val v = when(n) {
                    0 -> a concat b
                    1 -> b concat a
                    else -> 0
                }
                f = isPrime(v)
                n++
            }
            if(!f) continue
            for(k in j + 1 until max - 1) {
                f = true
                n = 0
                val c = primes[k]

                while(f && n < 4) {
                    val v = when(n) {
                        0 -> a concat c
                        1 -> b concat c
                        2 -> c concat a
                        3 -> c concat b
                        else -> 0
                    }
                    f = isPrime(v)
                    n++
                }
                if(!f) continue
                for(l in k + 1 until max) {
                    f = true
                    n = 0
                    val d = primes[l]

                    while(f && n < 6) {
                        val v = when(n) {
                            0 -> a concat d
                            1 -> b concat d
                            2 -> c concat d
                            3 -> d concat a
                            4 -> d concat b
                            5 -> d concat c
                            else -> 0
                        }
                        f = isPrime(v)
                        n++
                    }
                    if(!f) continue
                    for(m in j + 1 until max + 1) {
                        f = true
                        n = 0
                        val e = primes[m]

                        while(f && n < 8) {
                            val v = when(n) {
                                0 -> a concat e
                                1 -> b concat e
                                2 -> c concat e
                                3 -> d concat e
                                4 -> e concat a
                                5 -> e concat b
                                6 -> e concat c
                                7 -> e concat d
                                else -> 0
                            }
                            f = isPrime(v)
                            n++
                        }
                        if(f) return a + b + c + d + e
                    }
                }
            }
        }
    }
    return 0
}

private infix fun Int.concat(other: Int) = (toString() + other.toString()).toLong()