package jpl.ch01.ex04;

class Factorial {
    public static void main(String[] args) {

        System.out.println("**************************************");
        System.out.println("0から9までの階乗の値を出力します。");

        for(int i = 0; i < 10; i++) {
            System.out.println( i + ": " + calcFactorial(i));
        }

        System.out.println("**************************************");

    }
    
    /* 引数の階乗を返す。引数が1未満の時は1を返す */
    public static long calcFactorial(int i) {
        if(i <= 0) {
            return 1;
        } else {
            return i * calcFactorial(i-1);
        }
    }
}
