package net.projecteuler.problems;

public class _006 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i < 101; i++) {
            sum += i*i;
        }
        System.out.println((int) Math.pow(5050, 2) - sum);
    }
}
