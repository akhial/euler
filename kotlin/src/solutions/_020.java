package solutions;

import math.IntegerUtilsKt;

import java.math.BigInteger;

/**
 * <p>EZ (Use Java lambdas to get the chars then map them to their numeric value.. sum.)</p>
 */

public class _020 {

    public static int factorialDigitSum() {
        BigInteger result = IntegerUtilsKt.bigFact(100);
        return result.toString().chars().map(Character::getNumericValue).sum();
    }
}
