package com.ruibo.demo.javabasic.io.blockio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class RedisClient {
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 10; i++) {
			Socket socket = new Socket("127.0.0.1", 9999);
//			Scanner scanner = new Scanner(System.in);
//			String s = scanner.nextLine();
//			System.out.println("<<<" + s);
//			socket.getOutputStream().write(s.getBytes());
//			System.out.println(">>>" + s);
			socket.close();
		}

	}
}
