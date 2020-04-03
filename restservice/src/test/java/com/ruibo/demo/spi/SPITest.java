package com.ruibo.demo.spi;

import org.junit.Test;

import java.util.ServiceLoader;

public class SPITest {
	@Test
	public void testSayHi() throws Exception {
		ServiceLoader<Developer> serviceLoader = ServiceLoader.load(Developer.class);
		serviceLoader.forEach(Developer::sayHi);
	}

}
