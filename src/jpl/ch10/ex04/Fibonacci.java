package jpl.ch10.ex04;

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

        int i = 1;
        /* do whileにすると、大きさ1以下のフィボナッチ数列の場合、
         アクセス違反をおこす。*/
        while(i < fibonacciArray.length) {
            fibonacciArray[i] = hi;
            hi = lo + hi;
            lo = hi - lo;
            i++;
        }

        /* do whileにすると、フィボナッチ数列が空配列の場合、
         アクセス違反をおこす。*/
        i = 0;
        while(i < fibonacciArray.length) {
            System.out.println(fibonacciArray[i++]);
        }
        System.out.println(boundary);

    }
}
