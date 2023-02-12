package solutions

import math.PrimeSieve
import math.isPrime

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
 * I also used memoization to prevent rechecking for primes I'd already checked by using a [HashMap] mapping each prime
 * value to the boolean result of [isPrime].
 * All of which gave the final result below, it currently runs in less than a second on my machine. While I could have
 * found a simpler solution, sticking with my first attempt paid off.
 */

private val primes = PrimeSieve.getSieve().getPrimes(10000)
private val max = primes.size
private val check = HashMap<Long, Boolean>()

fun primePairSets(): Int {
    val isPrime = { v: Long ->
        check[v] ?: {
            val r = v.isPrime()
            check[v] = r
            r
        }()
    }

    for(i in 1 until max - 4) {
        var f: Boolean
        var n: Int
        val a = primes[i]
        for(j in i + 1 until max - 3) {
            f = true
            n = 0
            val b = primes[j]

            while(f && n < 2) {
                val v = when(n) {
                    0 -> a cat b
                    1 -> b cat a
                    else -> 0
                }
                f = isPrime(v)
                n++
            }
            if(!f) continue
            for(k in j + 1 until max - 2) {
                f = true
                n = 0
                val c = primes[k]

                while(f && n < 4) {
                    val v = when(n) {
                        0 -> a cat c
                        1 -> b cat c
                        2 -> c cat a
                        3 -> c cat b
                        else -> 0
                    }
                    f = isPrime(v)
                    n++
                }
                if(!f) continue
                for(l in k + 1 until max - 1) {
                    f = true
                    n = 0
                    val d = primes[l]

                    while(f && n < 6) {
                        val v = when(n) {
                            0 -> a cat d
                            1 -> b cat d
                            2 -> c cat d
                            3 -> d cat a
                            4 -> d cat b
                            5 -> d cat c
                            else -> 0
                        }
                        f = isPrime(v)
                        n++
                    }
                    if(!f) continue
                    for(m in j + 1 until max) {
                        f = true
                        n = 0
                        val e = primes[m]

                        while(f && n < 8) {
                            val v = when(n) {
                                0 -> a cat e
                                1 -> b cat e
                                2 -> c cat e
                                3 -> d cat e
                                4 -> e cat a
                                5 -> e cat b
                                6 -> e cat c
                                7 -> e cat d
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

private infix fun Int.cat(o: Int) = (toString() + o.toString()).toLong()
