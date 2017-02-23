package jpl.ch14.ex05;

public class AddValueThread implements Runnable {

    private int delayTime;
    private int addValue;
    private int loopNum;
    private static ValueCount counter;

    AddValueThread( ValueCount counter, int addValue, int delayTime, int loopNum) {
        this.counter = counter;
        this.addValue = addValue;
        this.delayTime = delayTime;
        this.loopNum = loopNum;
    }

    public void run() {
        try{
            for(int i = 0; i < loopNum; i++) {
                counter.add(addValue);
                Thread.sleep(delayTime);
            }

        } catch (InterruptedException e) {
            return;
        }
    }

}
