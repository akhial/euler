package solutions;

/**
 * <p>Just some boring code to generate the english spoken numbers, then sum.</p>
 */

public class _017 {

    public static int numberLetterCounts() {
        int total = 0;
        for(int i = 1; i < 1001; i++) {
            total += letterCount(i);
        }
        return total;
    }

    private static int letterCount(int n) {
        StringBuilder sb = new StringBuilder();
        if(n > 1000 || n < 0)
            throw new IllegalStateException("Number has to be smaller than 1000"); // for the lulz
        if(n == 1000) {
            return "onethousand".length();
        }
        sb.append(numerals(n/100));
        if(sb.length() != 0)
            sb.append("hundred");
        if(sb.length() != 0 && n%100 != 0) {
            sb.append("and");
        }
        if(n%100 >= 20) {
            sb.append(tens((n/10)%10));
            sb.append(numerals(n%10));
        } else if(n%100 >= 10) {
            sb.append(teens(n%10));
        } else {
            sb.append(numerals(n%10));
        }
        //System.out.println(sb.toString());
        return sb.length();
    }

    private static String numerals(int n) {
        if(n > 9 || n < 0)
            throw new IllegalStateException("0 to 9 positives only");
        return switch (n) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "";
        };
    }

    private static String tens(int n) { // very beautiful code
        if(n > 9 || n < 2)
            throw new IllegalStateException("2 to 9 positives only");
        return switch (n) {
            case 2 -> "twenty";
            case 3 -> "thirty";
            case 4 -> "forty";
            case 5 -> "fifty";
            case 6 -> "sixty";
            case 7 -> "seventy";
            case 8 -> "eighty";
            case 9 -> "ninety";
            default -> "";
        };
    }

    private static String teens(int n) { // doge impressed, much wow
        if(n > 9 || n < 0)
            throw new IllegalStateException("0 to 9 positives only");
        return switch (n) {
            case 0 -> "ten";
            case 1 -> "eleven";
            case 2 -> "twelve";
            case 3 -> "thirteen";
            case 4 -> "fourteen";
            case 5 -> "fifteen";
            case 6 -> "sixteen";
            case 7 -> "seventeen";
            case 8 -> "eighteen";
            case 9 -> "nineteen";
            default -> "";
        };
    }

}
