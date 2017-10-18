package net.projecteuler.problems;

public class _28_SpiralDiagSum {

    public static final int SPIRAL_SIZE = 101;

    public static void main(String[] args) {
        System.out.println(spiralSum(SPIRAL_SIZE));
    }

    public static int spiralSum(int size) {
        int sum = 1;
        for(int i = 3; i <= size; i += 2) {
            int n = i*i;
            int v = i-1;
            sum += 4*n - 6*v;
        }
        return sum;
    }
}
