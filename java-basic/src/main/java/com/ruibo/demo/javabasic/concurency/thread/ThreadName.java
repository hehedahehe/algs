package com.ruibo.demo.javabasic.concurency.thread;

public class ThreadName {

	public static void main(String[] args) {
		Thread thread = new Thread();
		thread.setName("hello world thread");
		System.out.println(thread.getName());
		System.out.println(Thread.currentThread().getName());
	}
}
