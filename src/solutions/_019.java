package solutions;

/**
 * <p>Solved this by actually implementing a calendar :P, after that you iterate over all possible dates remembering
 * the sundays as they occur.</p>
 */

public class _019 {

    private static final int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int countingSundays() {
        int day = 1;
        int month = 1;
        int year = 1901;
        int weekday = 1;
        int count = 0;

        while(year != 2001) {
            if(weekday == 0 && day == 1) {
                count++;
            }
            day++;
            weekday++;
            weekday %= 7;
            if(day > monthDays[month - 1]) {
                month++;
                day = 1;
            }
            if(month == 13) {
                year++;
                month = 1;
                if(isLeapYear(year))
                    monthDays[1] = 29;
                else
                    monthDays[1] = 28;
            }
        }
        return count - 1;
    }

    private static boolean isLeapYear(int year) {
        return (year%4 == 0) && (year%100 != 0 || year%400 == 0);
    }

    private static String dayName(int weekday) {
        switch(weekday) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                break;
        }
        return "";
    }
}