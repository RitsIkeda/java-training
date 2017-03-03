package jpl.ch13.ex05;

public class IntStrSeparator {

    public static String IntStrSeparator(String target) {
        final int separeteNum = 3;
        String result = "";
        if(target.length() <= separeteNum) {
            return target;
        }
        int spetatePos = (target.length() % separeteNum);
        if( spetatePos == 0) { spetatePos = separeteNum; }

        result += target.substring(0,spetatePos) + ",";
        while(true) {
            result += target.substring(spetatePos, spetatePos + separeteNum );
            if( target.length() <= spetatePos + separeteNum) {
                break;
            }
            result += ",";
            spetatePos += separeteNum;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(IntStrSeparator("123"));
        System.out.println(IntStrSeparator("1234"));
        System.out.println(IntStrSeparator("12345"));
        System.out.println(IntStrSeparator("123456"));
        System.out.println(IntStrSeparator("1234567"));
    }

}
