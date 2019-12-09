package net.projecteuler.math;

import java.math.BigInteger;

public class Fibonacci {

    private long fibA = 1;
    private long fibB = 1;

    private BigInteger bigFibA = BigInteger.ONE;
    private BigInteger bigFibB = BigInteger.ONE;

    public long nextFibonacci() {
        long result = fibA + fibB;
        fibA = fibB;
        fibB = result;

        return result;
    }

    public BigInteger nextBigFibonacci() {
        BigInteger result = bigFibA.add(bigFibB);
        bigFibA = bigFibB;
        bigFibB = result;

        return result;
    }

    public BigInteger nthBigFibonacci(int n) {
        BigInteger result = BigInteger.ZERO;
        Fibonacci f = new Fibonacci();

        if(n == 1 || n == 2) return BigInteger.ONE;

        for(int i = 0; i < n - 2; i++) {
            result = f.nextBigFibonacci();
        }
        return result;
    }
}