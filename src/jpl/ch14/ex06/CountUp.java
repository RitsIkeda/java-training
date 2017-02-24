package jpl.ch14.ex06;

public class CountUp {

    private long startSec;
    private final double milsecToSec = 0.01;

    public static void main(String[] args ) {
        CountUp countUp = new CountUp();
        new CountThread(countUp).start();
        new WaitThread(countUp,15).start();
        new WaitThread(countUp,7).start();
    }

    public int nowSec() {
        return (int) ((System.currentTimeMillis() - startSec) / 100); /* < for speed up */
    }

    public CountUp() {
        startSec =  System.currentTimeMillis();
    }
    public synchronized void waitInterval(int intervelSec) {
        try{
            while(nowSec() % intervelSec != 0 && nowSec() < 100) {
                wait();
            }
            System.out.println("waited " + intervelSec + " sec. nowTime" + nowSec() );
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
    public synchronized void count() {
            System.out.println(nowSec() + " sec elapsed");
            notifyAll();
    }
}
