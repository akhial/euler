package solutions;

/**
 * <p>We calculate all the remainders storing them as we go, when we encounter a remainder
 * we have already stored we stop. Then we get:</p>
 * <p>CycleLength = CurrentEncounterIndex - FirstEncounterIndex</p>
 */

public class _026 {

    private static final int MAX_REMAINDER = 1000;

    public static void main(String[] args) {
        int max = 0;

        for(int denominator = 6; denominator < 1000; denominator++) {
            if(cycleLength(denominator) > max) {
                max = denominator;
            }
        }
        System.out.println(max);
    }

    private static int search(int v, int[] array) {
        int index = -1;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == v) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static int cycleLength(int denominator) {
        int cycle = 0;
        int[] remainders = new int[MAX_REMAINDER];
        int index = 0;
        int first;
        int remainder = 1%denominator;
        while((first = search(remainder, remainders)) == -1 && remainder != 0) {
            cycle++;
            remainders[index++] = remainder;
            remainder *= 10;
            remainder %= denominator;
        }
        return cycle - first;
    }
}