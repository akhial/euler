package net.projecteuler.problems;

import java.util.Arrays;

public class _23_AbundantNumberSum {

    private static final int ABUNDANT_TOTAL = 6965;

    public static void main(String[] args) {
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
        System.out.println(total);
    }

    private static boolean isAbundant(int n) {
        int sum = 0;

        for(int i = 1; i < n/2+1; i++) {
            if(n%i == 0)
                sum += i;
        }
        return sum > n;
    }
}
