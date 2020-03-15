package com.ruibo.lock;

import org.openjdk.jol.info.ClassLayout;

public class SynchDemo {

	public static void main(String[] args) {
		Object o = new Object();
		String s = ClassLayout.parseInstance(o).toPrintable();
		System.out.println(s);


//		System.out.println("加锁后。。。。。");
//
//
//		synchronized (o){
//			s = ClassLayout.parseInstance(o).toPrintable();
//			System.out.println(s);
//		}
	}
}
