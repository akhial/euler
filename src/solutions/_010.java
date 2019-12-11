package solutions;

import math.PrimeUtils;

public class _010 {

    public static long summationOfPrimes() {
        long sum = 0;
        for(int i = 2; i <= 2000000; i++) {
            if(PrimeUtils.isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }
}
