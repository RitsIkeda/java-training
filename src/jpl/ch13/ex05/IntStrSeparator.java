package jpl.ch13.ex05;

public class IntStrSeparator {

    public static String intStrSeparate(String target) {
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

        /* teacher's ansewer */
        /*
        StringBuilder sb = new StringBuilder(source);

        for(int i = source.length() - separeteNum; i > 0; i -= separeteNum) {
            sb.insert(i,',');
        }
        return sb.toString();
        */
    }

    public static void main(String args[]) {
        System.out.println(intStrSeparate("123"));
        System.out.println(intStrSeparate("1234"));
        System.out.println(intStrSeparate("12345"));
        System.out.println(intStrSeparate("123456"));
        System.out.println(intStrSeparate("1234567"));
    }

}
