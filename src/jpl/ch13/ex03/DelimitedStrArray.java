package jpl.ch12.ex013;

public class DelimitedStrArray {
    public String[] delimitedStrArray(String from, char start, char end, int limit) {
        int startPos = from.indexOf(start);
        int endPos = from.indexOf(end);
        int strCount = 0;
        String[] buff = new String[limit];

        while( startPos != -1 && limit > strCount) {
            if(startPos > endPos) {
                from = from.substring(startPos);
            } else {
                from = from.substring(startPos, endPos + 1);
            }
            buff[strCount] = from;
            strCount++;
            startPos = from.indexOf(start);
            endPos = from.indexOf(end);
        }
        String[] result = new String[strCount];
        System.arraycopy(buff, 0, result, 0, strCount);
        return result;
    }
}
