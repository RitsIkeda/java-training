package java8.ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;

public final class WithLock {

	public static void main(String[] args) {

		MyLock myLock = new MyLock();
		withLock( myLock,  () -> System.out.println("runned") );

	}

	public static class MyLock extends ReentrantLock {
		@Override
		public void lock() {
			super.lock();
			System.out.println("locked");
		}

		@Override
		public void unlock() {
			super.lock();
			System.out.println("unlocked");
		}
	}

	public static void withLock(ReentrantLock lock, Runnable runnable) {
        lock.lock();
        try {
            runnable.run();
        } finally {
            lock.unlock();
        }
    }

}
