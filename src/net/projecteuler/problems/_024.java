package net.projecteuler.problems;

import net.projecteuler.api.Factorial;

import java.util.Arrays;

/**
 * <p>I coded this a while back but I'll try my best to explain this solution,
 * probably the best way to do so is by an example:</p>
 * <p> The number of possible arrangements of any 10 digit sequence without repetition is 10!
 * so the order of the final lexicographic arrangement of 0 through 10 is 10!
 * </p>
 * <p> I proceed to find the digits one by one using this insight instead of brute-forcing all
 * possible arrangements. This is done by fixing the nth digit starting with the first.
 * <blockquote>
 * 0 _ _ _ _ _ _ _ _ _
 * </blockquote>
 * </p>
 * <p>The order of the last lexicographic arrangement starting with a 0 is 9! being 0987654321.
 * So 0 is not the first digit because 9! = 362880 < 1000000
 * </p>
 * <p>1 isn't the first digit either since 2*9! = 725760 < 1000000, multiplied by 2 because the order of the
 * lexicographic arrangement of the form:
 * <blockquote>
 * 1 _ _ _ _ _ _ _ _ _
 * </blockquote>
 * is the order of the maximum 0-arrangement (362880) + the order of the 1-arrangement hence 2 times.
 * The correct starting digit is 2 because 3*9! > 1000000.</p>
 * <p>The gist of the solution is to find the digits one by one using this, by subtracting (digitPlace)!
 * from the previous order attained (in this case 1000000 - 2*9! = 274240) until we use up all our digits.
 * The next digit should be 6 because 7*8! > 274240 but if a digit isn't available we skip it. So the correct digit
 * is 7 because it is the 6th unused digit having skipped 2.
 * <blockquote>
 * 2 7 _ _ _ _ _ _ _ _
 * </blockquote></p>
 * <p>The use of digits is tracked via the {@code available} array.</p>
 */

public class _024 {

    public static void main(String[] args) {
        int place = 9, order = 1000000, digit;
        long result = 0;

        boolean[] available = new boolean[10];
        Arrays.fill(available, true);
        
        while(place >= 0) {
            digit = -1;
            while(order > 0) {
                order -= Factorial.factorial(place);
                digit++;
                while(!available[digit])
                    digit++;
            }
            available[digit] = false;
            order += Factorial.factorial(place);
            result += Math.pow(10, place)*digit;
            place--;
        }
        System.out.println(result);
    }
}
