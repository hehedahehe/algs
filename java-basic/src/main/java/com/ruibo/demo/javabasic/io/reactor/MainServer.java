package com.ruibo.demo.javabasic.io.reactor;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class MainServer {

	public static void main(String[] args) {
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			InetSocketAddress address = new InetSocketAddress(9999);
			serverSocketChannel.socket().bind(address);
			serverSocketChannel.configureBlocking(false);

			Selector selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT,new Acceptor(serverSocketChannel,selector));

			//监控selector的OP_ACCEPT事件
			TCPAcceptReactor tcpAcceptReactor = new TCPAcceptReactor(selector);


			tcpAcceptReactor.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
