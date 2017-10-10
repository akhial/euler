package net.projecteuler.problems;

public class _17_EnglishNumbers {

    public static void main(String[] args) {
        int total = 0;
        for(int i = 1; i < 1001; i++) {
            total += letterCount(i);
        }
        System.out.println(total);
    }

    private static int letterCount(int n) {
        StringBuilder sb = new StringBuilder();
        if(n > 1000 || n < 0)
            throw new IllegalStateException("Number has to be smaller than 1000");
        if(n == 1000) {
            //System.out.println("onethousand");
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
        switch(n) {
            case 0:
                return "";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
        }
        return "";
    }

    private static String tens(int n) {
        if(n > 9 || n < 2)
            throw new IllegalStateException("2 to 9 positives only");
        switch(n) {
            case 2:
                return "twenty";
            case 3:
                return "thirty";
            case 4:
                return "forty";
            case 5:
                return "fifty";
            case 6:
                return "sixty";
            case 7:
                return "seventy";
            case 8:
                return "eighty";
            case 9:
                return "ninety";
        }
        return "";
    }

    private static String teens(int n) {
        if(n > 9 || n < 0)
            throw new IllegalStateException("0 to 9 positives only");
        switch(n) {
            case 0:
                return "ten";
            case 1:
                return "eleven";
            case 2:
                return "twelve";
            case 3:
                return "thirteen";
            case 4:
                return "fourteen";
            case 5:
                return "fifteen";
            case 6:
                return "sixteen";
            case 7:
                return "seventeen";
            case 8:
                return "eighteen";
            case 9:
                return "nineteen";
        }
        return "";
    }
}
