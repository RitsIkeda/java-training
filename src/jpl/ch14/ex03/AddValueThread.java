package jpl.ch14.ex03;


public class AddValueThread implements Runnable {

    private int delayTime;
    private int addValue;
    private int loopNum;
    private static ValueCount counter;

    AddValueThread( ValueCount counter, int addValue, int delayTime, int loopNum) {
        AddValueThread.counter = counter;
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
    public static void main(String[] args) {
        ValueCount counter = new ValueCount();
        Runnable t1 = new AddValueThread(counter, 5, 3, 4);
        Runnable t2 = new AddValueThread(counter, 10, 4, 2);
        Runnable t3 = new AddValueThread(counter, 2, 2, 10);
        Runnable t4 = new AddValueThread(counter, 1, 1, 20);
        Runnable t5 = new AddValueThread(counter, 20, 2, 1);
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
        new Thread(t5).start();
    }

}
