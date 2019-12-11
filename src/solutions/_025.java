package solutions;

import math.FibIterator;

import java.math.BigInteger;

/**
 * <p>Cheating XD, simply use the Java implementation of {@link BigInteger}.</p>
 */

public class _025 {

    public static void main(String[] args) {
        int order = 2;
        BigInteger number = BigInteger.ZERO;
        FibIterator fibonacci = new FibIterator();

        while(!isOneK(number)) {
            number = fibonacci.nextBigFibonacci();
            order++;
        }
        System.out.println(order);
    }

    private static boolean isOneK(BigInteger bigInteger) {
        return bigInteger.compareTo(BigInteger.valueOf(10).pow(999)) > 0;
    }
}
