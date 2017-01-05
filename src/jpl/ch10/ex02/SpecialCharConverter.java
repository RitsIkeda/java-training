package jpl.ch10.ex02;

public class SpecialCharConverter {
    public static String convertSpecialChar( String str ) {

        char[] charArray = str.toCharArray();
        String result = null;
        char target;

        for(int i = 0;  i < charArray.length; i++ ) {

            target = charArray[i];
            switch(target) {
                case 0x000A:
                    target = '\n';
                    break;
                case 0x0009:
                    target = '\t';
                    break;
                case 0x0008:
                    target = '\b';
                    break;
                case 0x000D:
                    target = '\r';
                    break;
                case 0x000C:
                    target = '\f';
                    break;
                case 0x005C:
                    target = '\\';
                    break;
                case 0x0022:
                    target = '\"';
                    break;
                case 0x0027:
                    target = '\'';
                    break;
            }

            if(result == null) {
                result = String.valueOf(target);
            } else {
                result += target;
            }
        }
        return result;
    }
}
