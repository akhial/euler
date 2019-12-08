package net.projecteuler.api;

import java.math.BigInteger;

public class Factorial {

    private Factorial() {}

    public static long factorial(int n) {
        return NumberKt.fact(n);
    }

    public static BigInteger largeFactorial(int n) {
        if(n == 0)
            return BigInteger.ONE;
        if(n == 1)
            return BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        for(int i = 1; i < n + 1; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
