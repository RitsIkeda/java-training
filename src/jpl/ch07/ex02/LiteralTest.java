package jpl.ch07.ex02;

public class LiteralTest {

    public static void main(String[] args) {
        int floatToInt = (int) 3.14f;
        float intToFloat = 0x7fffffff;
        double intToDouble = 0x7fffffff;
        //int trueToInt = (int) true; //compile error
        //int falseToInt = (int) false; /compile error
        char intTochar = 0x500B;
        char doubleTochar = (char) 68.123;
        char floatTochar = (char) 1.0223e2f;
        System.out.println("floatToInt:" + floatToInt );
        System.out.println("intToFloat:" + intToFloat);
        System.out.println("intToDouble:" + intToDouble);
        System.out.println("intTochar:" + intTochar);
        System.out.println("doubleTochar:" + doubleTochar);
        System.out.println("floatTochar:" + floatTochar);
    }
}
