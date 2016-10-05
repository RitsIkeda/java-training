package jpl.ch01.ex04;

class Factorial {
    public static void main(String[] args) {

        System.out.println("**************************************");
        System.out.println("値が1000未満の階乗の値を出力します。");

        int i = 1, j = 1;

        while(j < 1000) {
            System.out.println(j);
            j *= (++i);
        }

        System.out.println("**************************************");

    }
}
