package jpl.ch10.ex05;

public class OutBetweenChars {

    static void outBetweeneChars(char one, char another) {
        char small, big;
        if(one > another) {
            small = another;
            big = one;
        } else {
            small = one;
            big = another;
        }
        for(char c = small; c <= big; c++ ) {
            System.out.print(c);
        }
        System.out.println();
    }
    public static void main(String args[]) {
         outBetweeneChars('a','z');
         outBetweeneChars('z','a');
         outBetweeneChars('0','Z');
    }


}
