package net.projecteuler.api;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Inspired by code by Arnav Kr. Mandal from GeeksForGeeks.
 * Prime count upper bounds from: https://en.wikipedia.org/wiki/Prime-counting_function
 */

public class Eratosthenes {

    private static int[] primes = null;

    private static int isComposite(int x) {
        return (primes[x/64] & (1 << ((x >> 1) & 31)));
    }

    private static void setComposite(int x) {
        primes[x/64] |= (1 << ((x >> 1) & 31));
    }

    @NotNull
    public static ArrayList<Integer> sieve(int n) {
        double f = (n <= 1000) ? 1.25507 : 1.137;
        double l = f*n/Math.log(n);
        ArrayList<Integer> result = new ArrayList<>((int) l);

        primes = new int[n/64 + 1];

        for(int i = 3; i*i <= n; i += 2) {
            if(isComposite(i) == 0)
                for(int j = i*i, k = i << 1; j <= n; j += k)
                    setComposite(j);
        }

        result.add(2);
        for(int i = 3; i <= n; i += 2)
            if(isComposite(i) == 0)
                result.add(i);

        return result;
    }
}