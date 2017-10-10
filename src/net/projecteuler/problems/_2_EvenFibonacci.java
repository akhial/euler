package net.projecteuler.problems;

import net.projecteuler.api.Fibonacci;

public class _2_EvenFibonacci {

    public static void main(String[] args) {
        long next = 0;
        long sum = 0;
        Fibonacci fibonacci = new Fibonacci();

        while(next < 4000000) {
            next = fibonacci.nextFibonacci();

            if(next%2 == 0)
                sum += next;
        }
        System.out.println(sum);
    }
}
