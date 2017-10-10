package net.projecteuler.problems;

import java.math.BigInteger;

public class _16_LargeSum2 {

    public static void main(String[] args) {
        long sum = 0;
        BigInteger number = BigInteger.valueOf(2).pow(1000);
        for(char digit : number.toString().toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        System.out.println(sum);
    }
}
