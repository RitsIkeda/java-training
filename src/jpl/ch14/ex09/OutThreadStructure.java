

package jpl.ch14.ex09;


public class OutThreadStructure {

    private static final int MAX_ELEMNT = 10;

    public static synchronized void outStructure (ThreadGroup group) {
        new Thread(new Runnable() {
                public void run() { outGroup( group, 0);}
        }).start();
    }

    private static synchronized void print(String str, int depth) {
        try{
            Thread.sleep(50);
        } catch(InterruptedException e) {
            System.out.println("InterruptedException");
        }
        str = "┗" +str;
        for(int i = 0; i < depth; i++) {
            str = "\t" + str;
        }
        System.out.println(str);
    }

    private static void outGroup(ThreadGroup group, int depth) {
        print("Group Name:" + group.getName(),depth);

        Thread[] threads = new Thread[MAX_ELEMNT];
        int count = group.enumerate(threads, false);
        for(int i = 0; i < count; i++) {
            outThread(threads[i], depth + 1);
        }
        ThreadGroup[] groups = new ThreadGroup[MAX_ELEMNT];
        count = group.enumerate(groups, false);
        for(int i = 0; i < count; i++) {
            outGroup(groups[i], depth + 1);
        }
    }

    private static void outThread(Thread thread, int depth) {
        print("Thread Name:" + thread.getName(),depth);
    }
}
