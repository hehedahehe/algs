package com.ruibo.demo.javabasic.concurency.queuetest;

public interface IMQueue {

	void push(int value);

	void size();

	Node getHead();

	Node getTail();


	class Node {
		public int value;
		public Node next;
	}
}
