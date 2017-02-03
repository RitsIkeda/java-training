package jpl.ch12.ex05;

public class IntStrSeparator {

    public static String IntStrSeparator(String target) {
        final int separeteNum = 3;
        String result = "";
        if(target.length() <= separeteNum) {
            return target;
        }
        int spetatePos = (target.length() % separeteNum);
        if( spetatePos == 0) { spetatePos = separeteNum; }

        while(spetatePos < target.length()) {
            result = target.substring(spetatePos, spetatePos + separeteNum);
            target += ",";
            spetatePos += separeteNum;
        }
        return result;
    }

}
