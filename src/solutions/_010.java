package solutions;

import math.PrimeUtils;

public class _010 {

    public static void main(String[] args) {
        long sum = 0;
        for(int i = 2; i <= 2000000; i++) {
            if(PrimeUtils.isPrime(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
