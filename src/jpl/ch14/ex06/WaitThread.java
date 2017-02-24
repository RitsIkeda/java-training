package jpl.ch14.ex06;

public class WaitThread extends Thread {
    CountUp countUp;
    private int intervelSec;

    public WaitThread(CountUp countUp, int intervelSec) {
        this.countUp = countUp;
        this.intervelSec = intervelSec;
    }

    public void run() {
        while(countUp.nowSec() < 100) {
            countUp.waitInterval(intervelSec);
    }
}
}
