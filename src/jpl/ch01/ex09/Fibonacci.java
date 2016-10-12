package jpl.ch01.ex09;

class Fibonacci {
    private static int FIBONACCI_INDEX = 10;
    private static final String boundary =  "****************************************";
    private static final String message =  "1~" + FIBONACCI_INDEX + "番目までのフィボナッチ数列を出力します。"; /* utf-8 */
    private static int[] fibonacciArray = new int[FIBONACCI_INDEX];

    public static void main(String[] args) {

        System.out.println(boundary);
        System.out.println(message);
        int lo = 1;
        int hi = 1;
        fibonacciArray[0] = lo;

        for(int i = 1; i < fibonacciArray.length; i++) {
            fibonacciArray[i] = hi;
            hi = lo + hi;
            lo = hi - lo;
        }
        for(int i = 0; i < fibonacciArray.length; i++) {
            System.out.println(fibonacciArray[i]);
        }
        System.out.println(boundary);

    }
}
