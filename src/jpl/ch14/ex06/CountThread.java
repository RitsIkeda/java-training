package jpl.ch14.ex06;

public class CountThread extends Thread {
    CountUp countUp;

    public CountThread(CountUp countUp) {
        this.countUp = countUp;
    }

    public void run() {
        while(countUp.nowSec() < 101) {
            try {
            Thread.sleep(100);  /*< use 100 msec as 1 sec for speeding up */
            countUp.count();
        } catch(InterruptedException e) {}
        }
    }

}
