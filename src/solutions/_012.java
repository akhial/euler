package solutions;

public class _012 {

    public static long highlyDivisibleTriangularNumber() {
        int num = 0, i = 1;
        long number = 0;
        while(num < 500) {
            number = (i*(i + 1))/2;
            num = numberOfDivisors(number);
            i++;
        }
        return number;
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
