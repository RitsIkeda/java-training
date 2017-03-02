/*
 * Copyright (C) 2012, 2013, 2016 RICOH Co., Ltd. All rights reserved.
 */
package jpl.ch14.ex10;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to
 * be exectued by a thread.
 *
 * [Instruction]
 *  Implement one constructor and three methods.
 *  Don't forget to write a Test program to test this class.
 *  Pay attention to @throws tags in the javadoc.
 *  If needed, you can put "synchronized" keyword to methods.
 *  All classes for implementation must be private inside this class.
 *  Don't use java.util.concurrent package.
 */
public class ThreadPool {

    private int queueSize;
    private int numberOfThreads;
    enum Status {Stoped, Started}
    private Status status = Status.Stoped;
    private LinkedList<Runnable> queue = new LinkedList<Runnable> ();

    private class MyThread extends Thread
    {
        boolean running = true;
        private Thread head;
        public void forceStop() {
            running = false;
        }
        public synchronized void run() {

            //System.out.println("run");
            while(running) {
                synchronized(queue) {
                    while ( queue.isEmpty() || queue.size() > queueSize ) {
                        try {
                            //System.out.println("wait1");
                            //System.out.println("queue.size()" + queue.size() );
                            //System.out.println("queuesize" + queueSize );
                            queue.wait();
                            //System.out.println("wait2");
                            if(!running) break;
                        } catch (InterruptedException e) {}
                    }
                    //System.out.println("pop");
                    try {
                        head = new Thread(queue.removeFirst());
                        queue.notifyAll();
                    } catch(NoSuchElementException e) {
                        //System.out.println("NoSuchElementException");
                        return;
                    }
                }
                head.run();
            }
        }

    }
    private MyThread[] threads;

    /**
     * Constructs ThreadPool.
     *
     * @param queueSize the max size of queue
     * @param numberOfThreads the number of threads in this pool.
     *
     * @throws IllegalArgumentException if either queueSize or numberOfThreads
     *         is less than 1
     */
    public ThreadPool(int queueSize, int numberOfThreads) {
        if( queueSize < 1 || numberOfThreads < 1  ) {
            throw new IllegalArgumentException();
        }
        this.queueSize = queueSize;
        this.numberOfThreads = numberOfThreads;
        threads = new MyThread[numberOfThreads];
        //System.out.println("ThreadPool");
    }

    /**
     * Starts threads.
     *
     * @throws IllegalStateException if threads has been already started.
     */
    public void start() {
        if(status == Status.Stoped) {
            status = Status.Started;
        } else {
            throw new IllegalStateException();
        }
        //System.out.println("numberOfThreads is " + numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {

            threads[i] = new MyThread();
            threads[i].start();

        }
    }

    /**
     * Stop all threads and wait for their terminations.
     *
     * @throws IllegalStateException if threads has not been started.
     */
    public void stop() {
        //System.out.println("stop");
        if(status == Status.Started) {
            status = Status.Stoped;
            try{
                //System.out.println("join");
                /*
                */
                while(!queue.isEmpty()) {
                    Thread.sleep(50);
                }

                for(int i = 0; i < numberOfThreads; i ++) {
                    threads[i].forceStop();
                    while(threads[i].head != null && threads[i].head.isAlive()) {
                        Thread.sleep(50);
                    }

                }
                /*
                while(Thread.currentThread() != null && Thread.currentThread().isAlive()) {
                    System.out.println("sleep");
                    Thread.currentThread().join(10);
                }
                */
                //System.out.println("sleep");

            }  catch (InterruptedException e) {}
                //Thread.currentThread().interrupt();
                //System.out.println("joined");

            //queue.notifyAll();
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Executes the specified Runnable object, using a thread in the pool.
     * run() method will be invoked in the thread. If the queue is full, then
     * this method invocation will be blocked until the queue is not full.
     *
     * @param runnable Runnable object whose run() method will be invoked.
     *
     * @throws NullPointerException if runnable is null.
     * @throws IllegalStateException if this pool has not been started yet.
     */
    public synchronized void dispatch(Runnable runnable) {
        if(runnable == null) {
            throw new NullPointerException();
        }
        if(status == Status.Stoped) {
            throw new IllegalStateException();
        }
        synchronized(queue) {
            //System.out.println("add");
            while(queue.size() >= queueSize) {
                try {
                    queue.wait();
                } catch(InterruptedException e) {

                }
            }
            synchronized(queue) {
                queue.addLast(runnable);
                queue.notifyAll();
            }

        }
    }
}
