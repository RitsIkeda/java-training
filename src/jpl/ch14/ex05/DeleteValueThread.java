package jpl.ch14.ex05;

public class DeleteValueThread implements Runnable {

    private int delayTime;
    private int deleteValue;
    private int loopNum;
    private static ValueCount counter;

    DeleteValueThread( ValueCount counter, int deleteValue, int delayTime, int loopNum) {
        DeleteValueThread.counter = counter;
        this.deleteValue = deleteValue;
        this.delayTime = delayTime;
        this.loopNum = loopNum;
    }

    public void run() {
        try{
            for(int i = 0; i < loopNum; i++) {
                synchronized(counter) {
                ValueCount.dangerDelete(deleteValue);
                Thread.sleep(delayTime);
            }
            }

        } catch (InterruptedException e) {
            return;
        }
    }
    public static void main(String[] args) {
        ValueCount counter = new ValueCount();
        Runnable addThread1 = new AddValueThread(counter, 5, 3, 4);
        Runnable addThread2 = new AddValueThread(counter, 10, 4, 2);
        Runnable addThread3 = new AddValueThread(counter, 2, 2, 10);
        Runnable addThread4 = new AddValueThread(counter, 1, 1, 20);
        Runnable addThread5 = new AddValueThread(counter, 20, 2, 1);
        Runnable deleteThread1 = new DeleteValueThread(counter, 4, 2, 4);
        Runnable deleteThread2 = new DeleteValueThread(counter, 10, 2, 2);
        Runnable deleteThread3 = new DeleteValueThread(counter, 2, 2, 10);
        Runnable deleteThread4 = new DeleteValueThread(counter, 1, 1, 20);
        Runnable deleteThread5 = new DeleteValueThread(counter, 20, 2, 1);
        new Thread(addThread1).start();
        new Thread(deleteThread1).start();
        new Thread(addThread2).start();
        new Thread(deleteThread2).start();
        new Thread(addThread3).start();
        new Thread(deleteThread3).start();
        new Thread(addThread4).start();
        new Thread(deleteThread4).start();
        new Thread(addThread5).start();
        new Thread(deleteThread5).start();
    }

}
