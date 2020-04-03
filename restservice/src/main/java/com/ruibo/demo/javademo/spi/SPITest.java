package com.ruibo.demo.javademo.spi;


import java.util.ServiceLoader;

public class SPITest {
	public static void main(String[] args) throws Exception {
		ServiceLoader<Developer> serviceLoader = ServiceLoader.load(Developer.class);
		serviceLoader.forEach(Developer::sayHi);
	}

}
