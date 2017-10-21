package net.projecteuler.api;

public class Primes {

    public static boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long) Math.sqrt(n) + 1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i - 1) == 0 || n%(i + 1) == 0) return false;
        }
        return true;
    }

    // Count number of set bits in an int
    private static int popCount(int n) {
        n -= (n >>> 1) & 0x55555555;
        n = ((n >>> 2) & 0x33333333) + (n & 0x33333333);
        n = ((n >> 4) & 0x0F0F0F0F) + (n & 0x0F0F0F0F);
        return (n*0x01010101) >> 24;
    }

    // Speed up counting by counting the primes per
    // array slot and not individually. This yields
    // another factor of about 1.24 or so.
    public static int nthPrime(int n) {
        if(n < 2) return 2;
        if(n == 2) return 3;
        if(n == 3) return 5;
        int limit, root, count = 2;
        limit = (int) (n*(Math.log(n) + Math.log(Math.log(n)))) + 3;
        root = (int) Math.sqrt(limit);
        if(limit%6 == 0) {
            limit = 2*(limit/6) - 1;

        } else if(limit%6 == 5) {
            limit = 2*(limit/6) + 1;

        } else {
            limit = 2*(limit/6);
        }
        switch(root%6) {
            case 0:
                root = 2*(root/6) - 1;
                break;
            case 5:
                root = 2*(root/6) + 1;
                break;
            default:
                root = 2*(root/6);
        }
        int dim = (limit + 31) >> 5;
        int[] sieve = new int[dim];
        for(int i = 0; i < root; ++i) {
            if((sieve[i >> 5] & (1 << (i & 31))) == 0) {
                int start, s1, s2;
                if((i & 1) == 1) {
                    start = i*(3*i + 8) + 4;
                    s1 = 4*i + 5;
                    s2 = 2*i + 3;
                } else {
                    start = i*(3*i + 10) + 7;
                    s1 = 2*i + 3;
                    s2 = 4*i + 7;
                }
                for(int j = start; j < limit; j += s2) {
                    sieve[j >> 5] |= 1 << (j & 31);
                    j += s1;
                    if(j >= limit) break;
                    sieve[j >> 5] |= 1 << (j & 31);
                }
            }
        }
        int i;
        for(i = 0; count < n; ++i) {
            count += popCount(~sieve[i]);
        }
        --i;
        int mask = ~sieve[i];
        int p;
        for(p = 31; count >= n; --p) {
            count -= (mask >> p) & 1;
        }
        return 3*(p + (i << 5)) + 7 + (p & 1);
    }
}
