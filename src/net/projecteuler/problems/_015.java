package net.projecteuler.problems;

import net.projecteuler.api.NumberKt;

import java.math.BigInteger;

public class _015 {

    public static void main(String[] args) {
        System.out.println(factorial(40).divide(factorial(20).multiply(factorial(20))));
    }

    private static BigInteger factorial(int n) {
        return NumberKt.bigFact(n);
    }
}
