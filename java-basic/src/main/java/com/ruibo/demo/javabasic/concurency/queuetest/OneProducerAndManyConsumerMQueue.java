package com.ruibo.demo.javabasic.concurency.queuetest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 单个消费者比较简单
 * 多个消费者就有些麻烦了
 *
 * 组内单播
 * vs
 * 组内多播
 * kafka如何实现
 *
 * 引入偏移量的思想
 */
public class OneProducerAndManyConsumerMQueue implements IMQueue {

	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	/**
	 * 初始状态消费清零
	 */
	private volatile byte consumerStatus = 0;


	@Override
	public void push(int value) {
		lock.lock();
		try {
			if (consumerStatus == 0) {
				//doProduce();
			} else {
				try {
					condition.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			lock.unlock();
		}
	}

	@Override
	public Node getHead() {
		return null;
	}

	@Override
	public Node getTail() {
		return null;
	}

	@Override
	public void size() {

	}


}
