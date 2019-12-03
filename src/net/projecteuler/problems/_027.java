package net.projecteuler.problems;

import net.projecteuler.api.Primes;

/**
 * <p>Straightforward, iterate over all quadratic expressions of the form n^2 + an + b
 * and find the one which generates the most primes consecutively.</p>
 */

public class _027 {

    public static void main(String[] args) {
        int max = 0;
        int newMax;
        int product = 0;
        for(int a = -1000; a < 1000; a++) {
            for(int b = -1000; b < 1000; b++) {
                if((newMax = primesGenerated(a, b)) > max) {
                    max = newMax;
                    product = a*b;
                }
            }
        }
        System.out.println(product);
    }

    public static int primesGenerated(int a, int b) {
        QuadraticExp exp = new QuadraticExp(1, a, b);
        int x = 0;
        while(Primes.isPrime(exp.calculateFor(x))) {
            x++;
        }
        return x - 1;
    }

    private static class QuadraticExp {
        private final int a;
        private final int b;
        private final int c;

        public QuadraticExp(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int calculateFor(int x) {
            return a*x*x + b*x + c;
        }
    }
}
