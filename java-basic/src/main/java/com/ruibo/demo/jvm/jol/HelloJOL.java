package com.ruibo.demo.jvm.jol;


import com.ruibo.demo.jvm.T;
import org.openjdk.jol.info.ClassLayout;

public class HelloJOL {
	private static Object j;

	public static void main(String[] args) {
		new HelloJOL().testPerson();
	}

	void testObject() {
		System.out.println("Object====");
		Object o = new Object();
		System.out.println(ClassLayout.parseInstance(o).toPrintable());

		System.out.println("类对象=====");
		System.out.println(ClassLayout.parseInstance(Object.class).toPrintable());
	}

	void testT() {
		T t = new T();
		String s = ClassLayout.parseInstance(t).toPrintable();
		System.out.println(s);
	}

	/**
	 * ➜  temp java -XX:+PrintCommandLineFlags -version
	 * -XX:InitialHeapSize=134217728 -XX:MaxHeapSize=2147483648 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseParallelGC
	 * om.ruibo.demo.jvm.jol.Person object internals:
	 *  OFFSET  SIZE               TYPE DESCRIPTION                               VALUE
	 *       0     4                    (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
	 *       4     4                    (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
	 *       8     4                    (object header)                           46 c1 00 f8 (01000110 11000001 00000000 11111000) (-134168250)
	 *      12     4                int Person.age                                0
	 *      16     4   java.lang.String Person.name                               null
	 *      20     4                    (loss due to the next object alignment)
	 * Instance size: 24 bytes
	 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
	 *
	 *
	 * -XX:-UseCompressedClassPointers -XX:-UseCompressedOops
	 *
	 * om.ruibo.demo.jvm.jol.Person object internals:
	 *  OFFSET  SIZE               TYPE DESCRIPTION                               VALUE
	 *       0     4                    (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
	 *       4     4                    (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
	 *       8     4                    (object header)                           40 88 b7 10 (01000000 10001000 10110111 00010000) (280463424)
	 *      12     4                    (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
	 *      16     4                int Person.age                                0
	 *      20     4                    (alignment/padding gap)
	 *      24     8   java.lang.String Person.name                               null
	 * Instance size: 32 bytes
	 * Space losses: 4 bytes internal + 0 bytes external = 4 bytes total
	 *
	 *
	 */
	void testPerson() {
		Person t = new Person();
		String s = ClassLayout.parseInstance(t).toPrintable();
		System.out.println(s);
	}
}
