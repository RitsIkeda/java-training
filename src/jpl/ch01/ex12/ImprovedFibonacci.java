package jpl.ch01.ex12;

class ImprovedFibonacci {

    private static final int MAX_INDEX = 10;

    public static void main(String[] args) {
        int lo = 1;
        int hi = 1;
        String mark = " *";
        MarkedNum[] markedNums = new MarkedNum[MAX_INDEX];
        String[] markedStrings =new String[MAX_INDEX];

        int i = 0;

        markedNums[i] = new MarkedNum(lo);
        markedStrings[i] = markedNums[i].getMarkedNum(i,mark);

        for(i = 1; i < markedNums.length; i++) {
            markedNums[i] = new MarkedNum(hi);
            markedStrings[i] = markedNums[i].getMarkedNum(i,mark);
            hi = lo + hi;
            lo = hi - lo;
        }
        for(i = 0; i < markedNums.length; i++) {
            System.out.println( markedStrings[i] );
        }
    }
}

class MarkedNum {
    private int num;
    private boolean isEven;

    public MarkedNum(int num) {
        this.num = num;
        if(num % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }
    }
    public String getMarkedNum(int index, String mark) {
        String retStr = index + ": " + num;
        if(isEven) { retStr += mark;}
        return retStr;
    }
}
