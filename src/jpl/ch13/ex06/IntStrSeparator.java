package jpl.ch13.ex06;

public class IntStrSeparator {

    public static String IntStrSeparator(String target, int separeteNum) {
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
