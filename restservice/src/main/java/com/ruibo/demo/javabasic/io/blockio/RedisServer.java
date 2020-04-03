package com.ruibo.demo.javabasic.io.blockio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RedisServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(9999);
		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println(String.format("server******来链接了 %s", socket));

			byte[] bytes = new byte[8];
			System.out.println(String.format("server******开始读取链接%s的数据了", socket));
			socket.getInputStream().read(bytes);
			Thread.sleep(5000);
			System.out.println(String.format("server******完成读取链接%s的数据--%s", socket, new String(bytes)));
		}
	}
}
