package net.projecteuler.api;

import java.util.ArrayList;

/**
 * Courtesy of GeeksForGeeks, by Arnav Kr. Mandal.
 */

public class Eratosthenes {

    private static int[] primes = null;

    private static int isComposite(int x) {
        return (primes[x/64] & (1 << ((x >> 1) & 31)));
    }

    private static void setComposite(int x) {
        primes[x/64] |= (1 << ((x >> 1) & 31));
    }

    public static ArrayList<Integer> sieve(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        primes = new int[n/64 + 1];

        for(int i = 3; i*i <= n; i += 2) {
            if(isComposite(i) == 0)
                for(int j = i*i, k = i << 1; j < n; j += k)
                    setComposite(j);
        }

        result.add(2);
        for(int i = 3; i <= n; i += 2)
            if(isComposite(i) == 0)
                result.add(i);

        return result;
    }
}
