package jpl.ch01.ex06;

class Fibonacci {
    static final String boundary =  "****************************************";
    static final String message = "値が100未満のフィボナッチ数列を出力します。"; /* utf-8 */

    public static void main(String[] args) {

        System.out.println(boundary);
        System.out.println(message);
        int lo = 1;
        int hi = 1;
        System.out.println(lo);

        while(hi < 100) {
            System.out.println(hi);
            hi = lo + hi;
            lo = hi - lo;
        }

        System.out.println(boundary);

    }
}
