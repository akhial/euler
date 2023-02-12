package solutions;

import math.PrimeUtils;

public class _003 {

    public static long largestPrimeFactor() {
        long check = 600851475143L;
        long largestFactor = 1;

        for(long l = 6; l < Math.sqrt(check); l++) {
            if(PrimeUtils.isPrime(l) && check%l == 0) {
                largestFactor = l;
            }
        }
        return largestFactor;
    }
}
