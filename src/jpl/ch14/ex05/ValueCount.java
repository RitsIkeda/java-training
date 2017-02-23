package jpl.ch14.ex05;


public class ValueCount {

    private static int currentValue = 0;

    ValueCount() {

    }
    public static synchronized void add(int addValue) {
        currentValue += addValue;
        System.out.println("addValue:" +addValue+ " currentValue:" + currentValue);
    }

    public static void dangerDelete(int deleteValue) {
        currentValue -= deleteValue;
        System.out.println("deleteValue:" + deleteValue + " deleteValue:" + currentValue);
    }
}
