package jpl.ch14.ex04;


public class ValueCount {

    private static int currentValue = 0;

    ValueCount() {

    }
    public static synchronized void add(int addValue) {
        currentValue += addValue;
        System.out.println("addValue:" +addValue+ " currentValue:" + currentValue);
    }
}
