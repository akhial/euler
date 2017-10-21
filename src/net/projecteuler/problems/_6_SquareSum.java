package net.projecteuler.problems;

public class _6_SquareSum {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i < 101; i++) {
            sum += i*i;
        }
        System.out.println((int) Math.pow(100*101/2, 2) - sum);
    }
}
