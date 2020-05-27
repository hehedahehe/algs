package com.ruibo.demo.javabasic.concurency.queuetest;

import com.alibaba.druid.sql.ast.statement.SQLForeignKeyImpl;

import java.util.Random;

public class QueueDemoMain {

	public static void main(String[] args) {

		OneProducerAndManyConsumerMQueue queue = new OneProducerAndManyConsumerMQueue();

		String consumer1 = "consumer1";
		String consumer2 = "consumer2";
		String consumer3 = "consumer3";

		queue.registerConsumer(consumer1);
		queue.registerConsumer(consumer2);
		queue.registerConsumer(consumer3);

		Runnable producerTask = () -> {
			while (true) {
				queue.push(new Random().nextInt());
			}
		};

		Runnable consumer1Task = () -> {
			while (true) {
				queue.consume(1, consumer1);
			}
		};
		Runnable consumer2Task = () -> {
			while (true) {
				queue.consume(1, consumer2);
			}
		};
		Runnable consumer3Task = () -> {
			while (true) {
				queue.consume(1, consumer3);
			}
		};

		new Thread(producerTask).start();
		new Thread(consumer1Task).start();
		new Thread(consumer2Task).start();
		new Thread(consumer3Task).start();

		//主线程等待
		while (true) {

		}


	}
}
