package net.projecteuler.problems;

import net.projecteuler.api.GeneralMath;

import java.math.BigInteger;

public class _15_LatticeRoutes {

    public static void main(String[] args) {
        System.out.println(factorial(40).divide(factorial(20).multiply(factorial(20))));
    }

    private static BigInteger factorial(int n) {
        return GeneralMath.largeFactorial(n);
    }
}
