package com.ruibo.demo.javabasic.concurency.syndemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.cnblogs.com/heqiyoujing/p/11145146.html
 */
public class ReentryLockDemo {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("--main begin");

		final SomethingShared somethingShared = new SomethingShared();
		Runnable changeStatusRunnable = new Runnable() {
			@Override
			public void run() {
				try {
					somethingShared.changeStatus();
				} catch (InterruptedException e) {
					//修改状态被中断，请妥善处置该异常
				}
			}
		};

		Thread t1 = new Thread(changeStatusRunnable);
		Thread t2 = new Thread(changeStatusRunnable);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("--main end");
	}

	/**
	 * 线程安全
	 * 采用可重入的方式
	 */
	public static class SomethingShared {
		private volatile int status;
		private final ReentrantLock reentrantLock = new ReentrantLock(true);

		void changeStatus() throws InterruptedException {
			System.out.println(Thread.currentThread() + "try lock");
			/**
			 * 如何实现可重入？
			 * synchronized锁特性：偏向锁、轻量级锁、重量级锁都是可重入的。
			 */
			/**
			 * Acquires the lock.
			 *
			 * <p>Acquires the lock if it is not held by another thread and returns
			 * immediately, setting the lock hold count to one.
			 *
			 * <p>If the current thread already holds the lock then the hold
			 * count is incremented by one and the method returns immediately.
			 *
			 * <p>If the lock is held by another thread then the
			 * current thread becomes disabled for thread scheduling
			 * purposes and lies dormant until the lock has been acquired,
			 * at which time the lock hold count is set to one.
			 * ***************具体实现逻辑******************************
			 *  protected final boolean tryAcquire(int acquires) {
			 *             final Thread current = Thread.currentThread();
			 *             int c = getState();
			 *             if (c == 0) {
			 *             //无线程占领，直接返回成功
			 *                 if (!hasQueuedPredecessors() &&
			 *                     compareAndSetState(0, acquires)) {
			 *                     setExclusiveOwnerThread(current);
			 *                     return true;
			 *                 }
			 *             }
			 *             else if (current == getExclusiveOwnerThread()) {
			 *             	    //有线程占领，但是是当线程 计数+1（AQS状态加1）
			 *                 int nextc = c + acquires;
			 *                 if (nextc < 0)
			 *                     throw new Error("Maximum lock count exceeded");
			 *                 setState(nextc);
			 *                 return true;
			 *             }
			 *             //占领失败
			 *             return false;
			 *         }
			 */
			reentrantLock.lock();
			System.out.println(Thread.currentThread() + "get lock");
			Thread.sleep(10203);
			status = status == 0 ? 1 : 0;
			reentrantLock.unlock();
			System.out.println(Thread.currentThread() + "release lock");
		}
	}
}
