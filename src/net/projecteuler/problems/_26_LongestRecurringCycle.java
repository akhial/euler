package net.projecteuler.problems;

public class _26_LongestRecurringCycle {

    public static void main(String[] args) {
        int max = 0;

        System.out.println(cycleLength(6));

        for(int denominator = 1; denominator <= 1000; denominator++) {
            System.out.println((double) 1/denominator);
        }
    }

    private static boolean search(int v, int[] array) {
        boolean found = false;
        for(int value : array) {
            found = value == v || found;
        }
        return found;
    }
        
    private static int cycleLength(int denominator) {
        int cycle = 0;
        int[] remainders = new int[10];
        int index = 0;
        int remainder = 1%denominator;
        while(!search(remainder, remainders) && remainder != 0) {
            cycle++;
            remainders[index++] = remainder;
            remainder *= 10;
            remainder %= denominator;
        }
        return cycle;
    }
}