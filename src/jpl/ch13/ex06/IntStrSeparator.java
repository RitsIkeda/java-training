package jpl.ch13.ex06;

public class IntStrSeparator {

    public static String IntStrSeparator(String target, int separeteNum) {
        String result = "";
        if(target.length() <= separeteNum || separeteNum == 0) {
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
        System.out.println(IntStrSeparator("1234",0));
        System.out.println(IntStrSeparator("1234",1));
        System.out.println(IntStrSeparator("1234",2));
        System.out.println(IntStrSeparator("1234",3));
        System.out.println(IntStrSeparator("1234",4));
    }

}
