package jpl.ch01.ex10;

class ImprovedFibonacci {

    private static final int MAX_INDEX = 10;

    public static void main(String[] args) {
        int lo = 1;
        int hi = 1;
        String mark = " *";
        MarkedNum[] markedNums = new MarkedNum[MAX_INDEX];

        markedNums[0] = new MarkedNum(lo);

        for(int i = 1; i < markedNums.length; i++) {
            markedNums[i] = new MarkedNum(hi);
            hi = lo + hi;
            lo = hi - lo;
        }
        for(int i = 0; i < markedNums.length; i++) {
            System.out.println( markedNums[i].getMarkedNum(i,mark) );
        }
    }
}

class MarkedNum {
    private int num;
    private boolean isEven;

    MarkedNum(int num) {
        this.num = num;
        if(num % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }
    }
    String getMarkedNum(int index, String mark) {
        String retStr = index + ": " + num;
        if(isEven) { retStr += mark;}
        return retStr;
    }
}
