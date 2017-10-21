package net.projecteuler.problems;

public class _1_ThreeAndFives {

    public static void main(String[] args) {
        int sum = 0;

        for(int i = 0; i < 1000; i++) {
            if(i%5 == 0 || i%3 == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
