package solutions;

public class _006 {

    public static int sumSquareDifference() {
        int sum = 0;
        for(int i = 1; i < 101; i++) {
            sum += i*i;
        }
        return (int) Math.pow(5050, 2) - sum;
    }
}
