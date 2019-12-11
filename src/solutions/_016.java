package solutions;

import java.math.BigInteger;

public class _016 {

    public static long powerDigitSum() {
        long sum = 0;
        BigInteger number = BigInteger.valueOf(2).pow(1000);
        for(char digit : number.toString().toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }
}
