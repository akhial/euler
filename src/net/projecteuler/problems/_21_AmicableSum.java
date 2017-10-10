package net.projecteuler.problems;

public class _21_AmicableSum {

    private static final int MAX = 10000;

    public static void main(String[] args) {
        long total = 0;
        int[] pastSums = new int[MAX];

        for(int i = 2; i < MAX; i++) {
            pastSums[i-2] = divisorSum(i);
        }
        for(int i = 2; i < MAX; i++) {
            if(pastSums[i-2] < MAX && pastSums[i-2] > 1 && pastSums[i-2] != i)
                if(pastSums[pastSums[i-2]-2] == i)
                    total += i;
        }
        System.out.println(total);
    }

    private static int divisorSum(int n) {
        int sum = 0;
        for(int i = 1; i <= n/2; i++) {
            if(n%i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}