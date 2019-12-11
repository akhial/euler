package solutions;

import math.FibIterator;

import java.math.BigInteger;

/**
 * <p>Cheating XD, simply use the Java implementation of {@link BigInteger}.</p>
 */

public class _025 {

    public static int _1000digitFibonacciNumber() {
        int order = 2;
        BigInteger number = BigInteger.ZERO;
        FibIterator fibonacci = new FibIterator();

        while(!isOneK(number)) {
            number = fibonacci.nextBigFibonacci();
            order++;
        }
        return order;
    }

    private static boolean isOneK(BigInteger bigInteger) {
        return bigInteger.compareTo(BigInteger.valueOf(10).pow(999)) > 0;
    }
}
