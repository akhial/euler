package math;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Bitwise functions by Arnav Kr. Mandal from GeeksForGeeks.
 * Prime count upper bounds from: https://en.wikipedia.org/wiki/Prime-counting_function
 */

public class PrimeSieve {

    private int maxCachedPrimes = 0;
    private int maxSievedPrimes = 0;
    private int[] primes = null;
    private ArrayList<Integer> cache = new ArrayList<>();
    private static PrimeSieve instance = new PrimeSieve();

    private PrimeSieve() {
    }

    public static PrimeSieve getSieve() {
        return instance;
    }

    public void reset() {
        maxCachedPrimes = 0;
        maxSievedPrimes = 0;
        cache = new ArrayList<>();
    }

    private ArrayList<Integer> getPrimeList(int n, int limit) {
        ArrayList<Integer> result;
        cache.ensureCapacity(limit);
        if(n >= maxCachedPrimes) {
            if(cache.isEmpty()) {
                cache.add(2);
            }
            int i = cache.get(cache.size() - 1);
            for(i = i == 2 ? 3 : i + 2; i <= n; i += 2) {
                if(isComposite(i) == 0) {
                    cache.add(i);
                }
            }
            maxCachedPrimes = n;
            result = cache;
        } else {
            result = new ArrayList<>();
            for(int p : cache) {
                if(p > n) break;
                result.add(p);
            }
        }
        return result;
    }

    private int isComposite(int x) {
        return (primes[x/64] & (1 << ((x >> 1) & 31)));
    }

    private void setComposite(int x) {
        primes[x/64] |= (1 << ((x >> 1) & 31));
    }

    public void sieve(int n) {
        if(n < 2 || n <= maxSievedPrimes) {
            return;
        }
        int size = n/64 + 1;
        if(maxSievedPrimes == 0) {
            primes = new int[size];
            setComposite(1);
        } else {
            int[] newPrimes = new int[size];
            System.arraycopy(primes, 0, newPrimes, 0, primes.length);
            primes = newPrimes;
        }
        for(int i = 3; i*i <= n; i += 2) {
            if(isComposite(i) == 0) {
                int j = i*i;
                int k = i << 1;
                while(j <= maxSievedPrimes) j += k;
                for(; j <= n; j += k) {
                    setComposite(j);
                }
            }
        }
        maxSievedPrimes = Math.max(maxSievedPrimes, n);
    }

    public boolean isPrime(int n) {
        if(n%2 == 0) {
            return false;
        }
        sieve(n);
        return isComposite(n) == 0;
    }

    @NotNull
    public ArrayList<Integer> getPrimes(int n) {
        int limit = (int) (n/Math.log(n - 1.5));
        if(n < 2) {
            return new ArrayList<>();
        }
        sieve(n);
        return getPrimeList(n, limit);
    }
}
