package jpl.ch14.ex03;


public class ValueCount {

    private int currentValue = 0;

    ValueCount() {

    }
    public synchronized void add(int addValue) {
        currentValue += addValue;
        System.out.println("addValue:" +addValue+ " currentValue:" + currentValue);
    }
}
