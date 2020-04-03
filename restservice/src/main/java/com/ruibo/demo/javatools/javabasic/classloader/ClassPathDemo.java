package com.ruibo.demo.javatools.javabasic.classloader;

public class ClassPathDemo {
	public static void main(String[] args) {
		new ClassPathDemo().test();
	}

	/**
	 * /Users/liruibo/Documents/code/github/algs/restservice/target/classes/com/ruibo/demo/classloader/ClassLoaderTest.class
	 */
	public void test(){
		java.net.URL resource = this.getClass().getResource("ClassLoaderTest.class");
		System.out.println(resource.getFile());
	}
}
