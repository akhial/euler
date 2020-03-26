package math;

public class IntegerUtils {

    public static int popCount(int i) {
        i -= (i >>> 1) & 0x55555555;
        i = ((i >>> 2) & 0x33333333) + (i & 0x33333333);
        i = ((i >> 4) & 0x0F0F0F0F) + (i & 0x0F0F0F0F);
        return (i*0x01010101) >> 24;
    }
}
