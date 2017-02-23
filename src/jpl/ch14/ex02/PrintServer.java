package jpl.ch14.ex02;

public class PrintServer implements Runnable {
    private final PrintQueue requests = new PrintQueue();
    private Thread myThread;

    public PrintServer() {
        myThread = new Thread(this);
        myThread.start();
    }
    public void run () {
        try {
            if(myThread != Thread.currentThread())
            {
                return;
            }
            while(true) {
                realPrint(requests.remove());
            }
        } catch( InterruptedException e) {
            return;
        }
    }
    public void print(PrintJob job) {
        requests.add(job);
    }
    private void realPrint(PrintJob job) {
        //real print job
    }
}
