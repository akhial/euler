package solutions;

import math.PrimeSieve;

public class _010 {

    public static long summationOfPrimes() {
        long sum = 0;
        PrimeSieve.getSieve().sieve(2000000);
        for(int i = 2; i <= 2000000; i++) {
            if(PrimeSieve.getSieve().isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }
}
