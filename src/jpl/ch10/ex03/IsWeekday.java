package jpl.ch10.ex03;


public class IsWeekday {


    /* switchを使った方が明瞭なコードである。
       同じ粒度のenumの値を並列に列挙できるため。 */

    public static boolean IsWeekdayUsingIf(Day day) {
        if(day == Day.SUNDAY) {
            return false;
        } else if(day == Day.MONDAY) {
            return true;
        } else if(day == Day.TUESDAY) {
            return true;
        } else if(day == Day.WEDNESDAY) {
            return true;
        } else if(day == Day.THURSDAY) {
            return true;
        } else if(day == Day.FRIDAY) {
            return true;
        } else if(day == Day.STATUERDAY) {
            return false;
        } else {
            throw new IllegalArgumentException("illegal day of argment");
        }
    }
    public static boolean IsWeekdayUsingSwitch(Day day) {
        switch(day) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                return true;

            case STATUERDAY:
            case SUNDAY:
                return false;

            default:
                throw new IllegalArgumentException("illegal day of argment");
        }
    }
}
