package net.projecteuler.api;

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
}
