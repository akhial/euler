package solutions;

import math.IntegerUtilsKt;

import java.math.BigInteger;

public class _015 {

    public static String latticePaths() {
        return factorial(40).divide(factorial(20).multiply(factorial(20))).toString();
    }

    private static BigInteger factorial(int n) {
        return IntegerUtilsKt.bigFact(n);
    }
}
