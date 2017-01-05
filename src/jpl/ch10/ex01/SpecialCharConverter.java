package jpl.ch10.ex01;


public class SpecialCharConverter {
    public static String convertSpecialChar( String str ) {

        char[] charArray = str.toCharArray();
        String result = null;

        for(int i = 0;  i < charArray.length; i++ ) {
            if( charArray[i] == 0x000A ) {
                if(result == null) {
                    result = "\n";
                } else {
                    result += '\n';
                }
            } else if ( charArray[i] == 0x0009 ) {
                if(result == null) {
                    result = "\t";
                } else {
                    result += '\t';
                }
            } else if ( charArray[i] == 0x0008 ) {
                if(result == null) {
                    result = "\b";
                } else {
                    result += '\b';
                }
            } else if ( charArray[i] == 0x000D ) {
                if(result == null) {
                    result = "\r";
                } else {
                    result += '\r';
                }
            } else if ( charArray[i] == 0x000C ) {
                if(result == null) {
                    result = "\f";
                } else {
                    result += '\f';
                }
            } else if ( charArray[i] == 0x005C ) {
                if(result == null) {
                    result = "\\";
                } else {
                    result += '\\';
                }
            }  else if ( charArray[i] == 0x0022 ) {
                if(result == null) {
                    result = "\"";
                } else {
                    result += '\"';
                }
            } else if ( charArray[i] == 0x0027 ) {
                if(result == null) {
                    result = "\'";
                } else {
                    result += '\'';
                }
            } else {
                if(result == null) {
                    result = String.valueOf(charArray[i]);
                } else {
                    result += charArray[i];
                }
            }
        }
        return result;
    }
}
