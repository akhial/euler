package net.projecteuler.problems;

public class _12 {

    public static void main(String[] args) {
        int num = 0, i = 1;
        long number = 0;
        while(num < 500) {
            number = (i*(i + 1))/2;
            num = numberOfDivisors(number);
            i++;
        }
        System.out.println(number);
    }

    private static int numberOfDivisors(long n) {
        int i;
        int num = 1;
        for(i = 2; i < Math.sqrt(n); i++) {
            if(n%i == 0) {
                num = num + 1;
            }
        }
        return num*2;
    }
}
