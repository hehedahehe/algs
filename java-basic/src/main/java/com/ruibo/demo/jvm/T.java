package com.ruibo.demo.jvm;

public class T {
	int m = 0;
	int c;
	long a;
	String st;
	T sub;

	public static void main(String args[]) {
		T t = new T();
		synchronized (T.class) {
			int a = 0;
		}
//		int b;
//		int c = 2 + b;
	}
}
