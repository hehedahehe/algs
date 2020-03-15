package com.ruibo;

public class T {
	int m = 0;
	int c;

	public static void main(String args[]) {
		T t = new T();
		synchronized (T.class) {
			int a = 0;
		}
		int b;
		int c = 2 + b;
	}
}
