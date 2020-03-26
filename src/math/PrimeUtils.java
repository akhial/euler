package math;

public class PrimeUtils {

    public static boolean isPrime(int i) {
        return isPrime((long) i);
    }

    public static boolean isPrime(long l) {
        if(l < 2) {
            return false;
        }
        if(l == 2 || l == 3) {
            return true;
        }
        if(l%2 == 0 || l%3 == 0) {
            return false;
        }
        long sqrtN = (long) Math.sqrt(l) + 1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(l%(i - 1) == 0 || l%(i + 1) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int nthPrime(int n) {
        if(n < 2) {
            return 2;
        }
        if(n == 2) {
            return 3;
        }
        if(n == 3) {
            return 5;
        }
        int limit, root, count = 2;
        limit = (int) (n*(Math.log(n) + Math.log(Math.log(n)))) + 3;
        root = (int) Math.sqrt(limit);
        limit = getLimit(limit);
        root = getLimit(root);
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
                    if(j >= limit) {
                        break;
                    }
                    sieve[j >> 5] |= 1 << (j & 31);
                }
            }
        }
        int i;
        for(i = 0; count < n; ++i) {
            count += IntegerUtils.popCount(~sieve[i]);
        }
        --i;
        int mask = ~sieve[i];
        int p;
        for(p = 31; count >= n; --p) {
            count -= (mask >> p) & 1;
        }
        return 3*(p + (i << 5)) + 7 + (p & 1);
    }

    private static int getLimit(int limit) {
        if(limit%6 == 0) {
            limit = 2*(limit/6) - 1;
        } else if(limit%6 == 5) {
            limit = 2*(limit/6) + 1;
        } else {
            limit = 2*(limit/6);
        }
        return limit;
    }
}
