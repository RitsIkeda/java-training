package jpl.ch13.ex02;

public class CountSpecifiedStr {
    public static int countSpecifiedStr(String target, char specifiedStr) {
        int count = 0;
        int result = target.indexOf(specifiedStr);
        while( result != -1 ) {
            count++;
            result = target.indexOf(specifiedStr, result);
        }
        return count;
    }
}
