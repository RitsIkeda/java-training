package jpl.ch14.ex01;

public class GetThreadNameDebug extends Thread {

    private int delayTime;
    public GetThreadNameDebug(int delayTime) {
        this.delayTime = delayTime;
    }
    public void run() {

        try {
            for( int sum = 0; sum < 1000; sum += delayTime) {
                System.out.println(getName());
                Thread.sleep(delayTime);
            }
        } catch (InterruptedException e) {
            return;
        }
    }

    public static void main(String[] args) {
        new GetThreadNameDebug(50).start();
        new GetThreadNameDebug(100).start();
        new GetThreadNameDebug(200).start();
    }
}
