/*
 * Copyright (C) 2012, 2013, 2016 RICOH Co., Ltd. All rights reserved.
 */
package jpl.ch14.ex10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to be exectued by a
 * thread.
 *
 * [Instruction] Implement one constructor and three methods. Don't forget to
 * write a Test program to test this class. Pay attention to @throws tags in the
 * javadoc. If needed, you can put "synchronized" keyword to methods. All
 * classes for implementation must be private inside this class. Don't use
 * java.util.concurrent package.
 */
public class ThreadPool {

	volatile private int queueSize;
	volatile private int numberOfThreads;

	private volatile boolean started = false;

	private List<Runnable> queue = Collections.synchronizedList(new ArrayList<Runnable>());

	private class MyThread extends Thread {

		volatile private boolean running = true;
		volatile private Thread head;

		public void forceStop() {
			running = false;
			head = null;
		}

		public synchronized void run() {
			//System.out.println("start1");
			while (running) {
				//System.out.println("start2");
				synchronized (queue) {
					while (queue.isEmpty() || queue.size() > queueSize) {

						try {
							//System.out.println("wait start size is" + queue.size());
							if (!running) {
								return;
							}
							queue.wait();
							//System.out.println("wait");
							//System.out.println("not return");
						} catch (InterruptedException e) {
							return;
						}
					}
					if (!running) {
						break;
					}
					//System.out.println("try");
					try {
						if (!queue.isEmpty()) {
							//System.out.println("new");
							head = new Thread(queue.remove(0));

						}
						queue.notifyAll();
					} catch (NoSuchElementException e) {
						return;
					}
				}
				if ( head != null) {
					head.run();
				}
			}
			//System.out.println("end1");
		}

	}

	private  List<MyThread> threads = Collections.synchronizedList(new ArrayList<MyThread>());

	/**
	 * Constructs ThreadPool.
	 *
	 * @param queueSize
	 *            the max size of queue
	 * @param numberOfThreads
	 *            the number of threads in this pool.
	 *
	 * @throws IllegalArgumentException
	 *             if either queueSize or numberOfThreads is less than 1
	 */
	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize < 1 || numberOfThreads < 1) {
			throw new IllegalArgumentException();
		}
		this.queueSize = queueSize;
		this.numberOfThreads = numberOfThreads;
	}

	/**
	 * Starts threads.
	 *
	 * @throws IllegalStateException
	 *             if threads has been already started.
	 */
	public void start() {
		synchronized (this) {


		if (!started ) {
			started = true;
		} else {
			throw new IllegalStateException();
		}
		// //System.out.println("numberOfThreads is " + numberOfThreads);
		for (int i = 0; i < numberOfThreads; i++) {
			MyThread thread= new MyThread();
			thread.setName("MY THREAD" + i);
			thread.start();
			threads.add(thread);

			//System.out.println("thread start");
		}
		}
	}

	/**
	 * Stop all threads and wait for their terminations.
	 *
	 * @throws IllegalStateException
	 *             if threads has not been started.
	 */
	public void stop() {
		synchronized (this) {
		if (started) {
			started = false;
			//System.out.println("stop start");

			while (!queue.isEmpty()) {
				//System.out.println("empty wait");
			}

			/*
			for (int i = 0; i < numberOfThreads; i++) {
				while (threads.get(i).head != null && threads.get(i).head.isAlive() ) {
					//System.out.println("wait threas");
				}
				threads.get(i).forceStop();
			}*/
			for (int i = 0; i < numberOfThreads; i++) {
				threads.get(i).forceStop();
				while (threads.get(i).isAlive() ) {
					synchronized (queue) {
						queue.notifyAll();
					}
				}
			}

		} else {
			throw new IllegalStateException();
		}
		}
	}

	/**
	 * Executes the specified Runnable object, using a thread in the pool. run()
	 * method will be invoked in the thread. If the queue is full, then this
	 * method invocation will be blocked until the queue is not full.
	 *
	 * @param runnable
	 *            Runnable object whose run() method will be invoked.
	 *
	 * @throws NullPointerException
	 *             if runnable is null.
	 * @throws IllegalStateException
	 *             if this pool has not been started yet.
	 */
	public synchronized void dispatch(Runnable runnable) {
		if (runnable == null) {
			throw new NullPointerException();
		}
		if (!started) {
			throw new IllegalStateException();
		}
		synchronized (queue) {
			//System.out.println("add");
			while (queue.size() >= queueSize) {
				try {
					queue.wait();
				} catch (InterruptedException e) {

				}
			}
		}
		synchronized (queue) {
			queue.add(runnable);
			queue.notifyAll();
		}

	}
}
