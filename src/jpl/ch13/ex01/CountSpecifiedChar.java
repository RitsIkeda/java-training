package jpl.ch13.ex01;

public class CountSpecifiedChar {
    public static int countSpecifiedChar(String target, char specifiedChar) {
        int count = 0;
        for(int i = 0; i < target.length(); i++ ) {
            if(target.charAt(i) == specifiedChar) {
                count++;
            }
        }
        return count;
    }
}
