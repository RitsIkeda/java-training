

package jpl.ch14.ex09;

import static org.junit.Assert.*;
import org.junit.Test;

public class OutThreadStructureTest {

    public class SleepThread extends Thread {
        public SleepThread(ThreadGroup group, String str) {
            super(group,str);
        }
        public void run() {
            try{
            Thread.sleep(1000);
            } catch(InterruptedException e) {

            }
        }
    }

    @Test
    public void test1 () throws InterruptedException  {
        System.out.println("Test start");

        ThreadGroup groupA = new ThreadGroup("groupA");
        SleepThread threadA_1 = new SleepThread(groupA, "threadA_1");
        SleepThread threadA_2 = new SleepThread(groupA, "threadA_2");
        threadA_1.start();
        threadA_2.start();

        ThreadGroup groupB = new ThreadGroup(groupA, "groupB");
        new Thread(new Runnable() {
                public void run() { OutThreadStructure.outStructure(groupA);}
        }).start();

        // Wait for other thread
       Thread.sleep(1000);
       System.out.println("Test end");
    }

    @Test
    public void test2 () throws InterruptedException  {
        System.out.println("Test start");

        ThreadGroup groupA = new ThreadGroup("groupA");
        SleepThread threadA_1 = new SleepThread(groupA, "threadA_1");
        SleepThread threadA_2 = new SleepThread(groupA, "threadA_2");
        threadA_1.start();
        threadA_2.start();

        ThreadGroup groupB = new ThreadGroup(groupA, "groupB");
        SleepThread threadB_1 = new SleepThread(groupB, "threadB_1");
        SleepThread threadB_2 = new SleepThread(groupB, "threadB_2");
        threadB_1.start();
        threadB_2.start();

        ThreadGroup groupC = new ThreadGroup(groupB, "groupC");
        SleepThread threadC_1 = new SleepThread(groupC, "threadC_1");
        threadC_1.start();

        ThreadGroup groupD = new ThreadGroup(groupA, "groupD");
        SleepThread threadD_1 = new SleepThread(groupD, "threadD_1");
        threadD_1.start();



        new Thread(new Runnable() {
                public void run() { OutThreadStructure.outStructure(groupA);}
        }).start();
        new Thread(new Runnable() {
                public void run() { OutThreadStructure.outStructure(groupB);}
        }).start();

        // Wait for other thread
       Thread.sleep(1000);
       System.out.println("Test end");
    }
}
