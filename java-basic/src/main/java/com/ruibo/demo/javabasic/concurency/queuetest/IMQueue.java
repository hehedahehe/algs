package com.ruibo.demo.javabasic.concurency.queuetest;

import java.util.List;

public interface IMQueue {

	void push(int value);

	List<Node> consume(int batchSize, String consumerName);


	class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}

		public Node() {
		}
	}
}
