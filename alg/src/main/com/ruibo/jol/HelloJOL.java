package com.ruibo.jol;

import com.ruibo.T;
import org.openjdk.jol.info.ClassLayout;

public class HelloJOL {

	public static void main(String[] args) {
		T t = new T();
		String s = ClassLayout.parseInstance(t).toPrintable();
		System.out.println(s);
	}
}
