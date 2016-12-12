package jpl.ch07.ex03;

public class PascalsTriangle {
    private final int MAX_SIZE;
    private static final int DEFAULT_SIZE = 12;
    private int[][] pascalTriangle;

    private void newPascalRow(int rowNum, int rowSize) {
        pascalTriangle[rowNum] = new int[rowSize];
    }
    private void makePascalRow(int rowNum) {
        if( rowNum < 0 || pascalTriangle[rowNum] == null) {
            throw new IllegalArgumentException();
        } else if(rowNum == 0) {
            pascalTriangle[rowNum][0] = 1;
        } else {
            for(int i = 0; i < pascalTriangle[rowNum-1].length; i++) {
                pascalTriangle[rowNum][i] += pascalTriangle[rowNum-1][i];
                pascalTriangle[rowNum][i+1] += pascalTriangle[rowNum-1][i];
            }
        }
    }
    public void makePascalsTriangle() {
        for(int i = 0; i <  MAX_SIZE; i++) {
            newPascalRow(i,i+1);
            makePascalRow(i);
        }
    }
    public void outPascalsTriangle() {
        for(int i = 0; i <  MAX_SIZE; i++) {
            outPasscalsLine(i);
        }
    }
    private void outPasscalsLine(int rowNum) {
        if( rowNum < 0 || pascalTriangle[rowNum] == null) {
            throw new IllegalArgumentException();
        }

        int i;
        System.out.print("{ ");
        for(i = 0; i < pascalTriangle[rowNum].length - 1; i++ ) {
            System.out.print( pascalTriangle[rowNum][i] + ", " );
        }
        System.out.print( pascalTriangle[rowNum][i] + " }," + "\r\n");
    }
    PascalsTriangle() {
        MAX_SIZE = DEFAULT_SIZE;
         pascalTriangle = new int[MAX_SIZE][];
    }
    PascalsTriangle(int pascalsSize) {
        MAX_SIZE = pascalsSize;
        pascalTriangle = new int[MAX_SIZE][];
    }
    public static void main(String[] args) {
        System.out.println("size 12");
        PascalsTriangle triangle = new PascalsTriangle();
        triangle.makePascalsTriangle();
        triangle.outPascalsTriangle();
        System.out.println("size 15");
        PascalsTriangle bigTriangle = new PascalsTriangle(15);
        bigTriangle.makePascalsTriangle();
        bigTriangle.outPascalsTriangle();
    }
}
