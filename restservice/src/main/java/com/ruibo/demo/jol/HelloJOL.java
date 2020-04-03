package com.ruibo.demo.jol;


import com.ruibo.demo.T;
import org.openjdk.jol.info.ClassLayout;

public class HelloJOL {
	private static Object j;

	public static void main(String[] args) {
		T t = new T();
		String s = ClassLayout.parseInstance(t).toPrintable();
		System.out.println(s);
		System.out.println("Object====");
		Object o = new Object();
		System.out.println( ClassLayout.parseInstance(o).toPrintable());
		System.out.println("类对象=====");
		System.out.println( ClassLayout.parseInstance(Object.class).toPrintable());
	}
}
