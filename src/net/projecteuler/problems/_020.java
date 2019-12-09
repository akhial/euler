package net.projecteuler.problems;

import net.projecteuler.math.NumberKt;

import java.math.BigInteger;

/**
 * <p>EZ (Use Java lambdas to get the chars then map them to their numeric value.. sum.)</p>
 */

public class _020 {

    public static void main(String[] args) {
        BigInteger result = NumberKt.bigFact(100);
        System.out.println(result.toString().chars().map(Character::getNumericValue).sum());
    }
}
