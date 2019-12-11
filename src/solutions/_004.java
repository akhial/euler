package solutions;

public class _004 {

    public static int largestPalindromeProduct() {
        int largest = 0;
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                int check = i*j;

                String s = new StringBuilder(String.valueOf(check)).reverse().toString();
                if(String.valueOf(check).equals(s)) {
                    if(check > largest)
                        largest = check;
                }
            }
        }
        return largest;
    }
}
