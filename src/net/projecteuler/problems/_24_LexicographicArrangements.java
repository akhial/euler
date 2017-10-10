package net.projecteuler.problems;

import net.projecteuler.api.GeneralMath;

public class _24_LexicographicArrangements {

    public static void main(String[] args) {
        int place = 9, order = 1000000, digit;
        long result = 0;

        boolean[] available = new boolean[10];
        for(int i = 0; i < available.length; i++) {
            available[i] = true;
        }
        while(place >= 0) {
            digit = -1;
            while(order > 0) {
                order -= GeneralMath.factorial(place);
                digit++;
                while(!available[digit])
                    digit++;
            }
            available[digit] = false;
            order += GeneralMath.factorial(place);
            result += Math.pow(10, place) * digit;
            place--;
        }
        System.out.println(result);
    }
}
