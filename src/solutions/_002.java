package solutions;

import math.FibIterator;

public class _002 {

    public static void main(String[] args) {
        long next = 0;
        long sum = 0;
        FibIterator fibonacci = new FibIterator();

        while(next < 4000000) {
            next = fibonacci.nextFibonacci();

            if(next%2 == 0)
                sum += next;
        }
        System.out.println(sum);
    }
}
