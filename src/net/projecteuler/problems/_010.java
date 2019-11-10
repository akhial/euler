package net.projecteuler.problems;

import net.projecteuler.api.Primes;

public class _010 {

    public static void main(String[] args) {
        long sum = 0;
        for(int i = 2; i <= 2000000; i++) {
            if(Primes.isPrime(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
