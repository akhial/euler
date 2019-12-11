package solutions;

/**
 * <p>To find all amicable numbers I calculate all d(n) for n<10000, then I look for the numbers i whose
 * divisorSum is equal to an element in the previously calculated d(n) different than i, and inferior to the maximum.
 * In which case if the divisorSum of that element is equal to i I consider it amicable, and add it to the sum.</p>
 */

public class _021 {

    private static final int MAX = 10000;

    public static long amicableNumbers() {
        long total = 0;
        int[] pastSums = new int[MAX];

        for(int i = 2; i < MAX; i++) {
            pastSums[i - 2] = divisorSum(i);
        }
        for(int i = 2; i < MAX; i++) {
            if(pastSums[i - 2] < MAX && pastSums[i - 2] > 1 && pastSums[i - 2] != i)
                if(pastSums[pastSums[i - 2] - 2] == i)
                    total += i;
        }
        return total;
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