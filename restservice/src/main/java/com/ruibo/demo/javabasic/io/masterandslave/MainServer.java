package com.ruibo.demo.javabasic.io.masterandslave;

public class MainServer {

	public static void main(String[] args) {
		try {
			TCPReactor reactor = new TCPReactor(123);
			reactor.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
