package jpl.ch01.ex03;

class Fibonacci {
    public static void main(String[] args) {

        System.out.println("**************************************");
        System.out.println("値が100未満のフィボナッチ数列を出力します。");
        int lo = 1;
        int hi = 1;
        System.out.println(lo);


        System.out.println(lo);

        while(hi < 100) {
            System.out.println(hi);
            hi = lo + hi;
            lo = hi - lo;
        }

        System.out.println("**************************************");

    }
}
