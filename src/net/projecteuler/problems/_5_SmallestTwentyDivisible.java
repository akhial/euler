package net.projecteuler.problems;

public class _5_SmallestTwentyDivisible {
    public static void main(String[] args) {
        int smallest = 0;
        boolean divisible = false;

        while(!divisible) {
            smallest += 1260;
            divisible = true;
            for(int i = 1; i <= 20; i++) {
                if(smallest % i != 0)
                    divisible = false;
            }
        }
        System.out.println(smallest);
    }
}
