package solutions;

import java.util.Arrays;

/**
 * <p>For this problem I brute-forced all abundant numbers, then I check each number to find if
 * the addend required is not abundant.</p>
 * <p>In other words, for any n < 28123 if for every abundant number i there doesn't exist an abundant number j where: i+j=n
 * I add that n to the sum.</p>
 */

public class _023 {

    private static final int ABUNDANT_TOTAL = 6965;

    public static int nonabundantSums() {
        int[] abundantNumbers = new int[ABUNDANT_TOTAL];
        int total = 0;

        for(int i = 0; i < 28123; i++) {
            if(isAbundant(i)) {
                abundantNumbers[total] = i;
                total++;
            }
        }
        total = 0;
        for(int i = 1; i < 28123; i++) {
            int j = 0;
            boolean writable = false;
            while(j < ABUNDANT_TOTAL && abundantNumbers[j] < i - 11 && !writable) {
                int operand = i - abundantNumbers[j];
                if(Arrays.binarySearch(abundantNumbers, operand) >= 0)
                    writable = true;
                j++;
            }
            if(!writable)
                total += i;
        }
        return total;
    }

    private static boolean isAbundant(int n) {
        int sum = 0;

        for(int i = 1; i < n/2 + 1; i++) {
            if(n%i == 0)
                sum += i;
        }
        return sum > n;
    }
}
