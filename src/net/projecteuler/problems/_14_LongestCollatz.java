package net.projecteuler.problems;

public class _14_LongestCollatz {

    public static void main(String[] args) {
        int start;
        long current;
        int counter = 1;
        int largest = 0;
        int bestStart = 0;

        for(start = 1; start < 1000000; start++) {
            current = start;
            while(current != 1) {
                if(current%2 == 0)
                    current /= 2;
                else {
                    current *= 3;
                    current++;
                }
                counter++;
            }
            if(counter > largest) {
                largest = counter;
                bestStart = start;
            }
            counter = 1;
        }

        System.out.println(bestStart + " " + largest);
    }
}
