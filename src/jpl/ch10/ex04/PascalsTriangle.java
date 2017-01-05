package jpl.ch10.ex04;

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
            int i = 0;
            /* do whileで書き換えることも可能
            1行目以上の行を描画するスコープのため。 */
            while( i < pascalTriangle[rowNum-1].length ) {
                pascalTriangle[rowNum][i] += pascalTriangle[rowNum-1][i];
                pascalTriangle[rowNum][i+1] += pascalTriangle[rowNum-1][i];
                i++;
            }
        }
    }
    public void makePascalsTriangle() {

        /* do whileで書き換えると、大きさ0の三角形のときに
          大きさ1のパスカルの3角形を作ってしまう。 */
        for(int i = 0; i <  MAX_SIZE; i++) {
            newPascalRow(i,i+1);
            makePascalRow(i);
        }
    }
    public void outPascalsTriangle() {
        int i = 0;

        /* do whileで書き換えると、大きさ0の三角形のときに
          出力を試みてしまう */
        while(i <  MAX_SIZE) {
            outPasscalsLine(i);
            i++;
        }
    }
    private void outPasscalsLine(int rowNum) {
        if( rowNum < 0 || pascalTriangle[rowNum] == null) {
            throw new IllegalArgumentException();
        }

        int i = 0;
        System.out.print("{ ");

        /* do whileで書き換えることはできない。
        　大きさ1以下のパスカルの3角形の場合に矛盾が生じる。 */
        while( i < pascalTriangle[rowNum].length - 1) {
            System.out.print( pascalTriangle[rowNum][i] + ", " );
            i++;
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
