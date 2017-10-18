package net.projecteuler.problems;

/**
 * <p>One has to notice that the top-right diagonal is just the squares of the column number,
 * then you find that the four corners are that square minus the column number - 1. eg:
 * <blockquote><pre>
 *          21 22 23 24 25 <- 25 = 5*5
 *          20  7  8  9 10
 *          19  6  1  2 11
 *          18  5  4  3 12
 *          17 16 15 14 13
 *
 *          21 = 25 -4
 *          17 = 25 -4 -4
 *          13 = 25 -4 -4 -4
 * </pre></blockquote>
 *
 * Hence this solution.</p>
*/
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
