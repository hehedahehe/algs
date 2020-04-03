package com.ruibo.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

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
			reentrantLock.lock();
			System.out.println(Thread.currentThread() + "get lock");
			Thread.sleep(10203);
			status = status == 0 ? 1 : 0;
			reentrantLock.unlock();
			System.out.println(Thread.currentThread() + "release lock");
		}
	}
}
