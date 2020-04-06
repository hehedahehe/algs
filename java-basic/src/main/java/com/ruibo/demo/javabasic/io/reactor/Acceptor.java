package com.ruibo.demo.javabasic.io.reactor;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Acceptor implements Runnable {

	private final ServerSocketChannel serverSocketChannel;
	private final Selector selector;

	public Acceptor(ServerSocketChannel serverSocketChannel, Selector selector) {
		this.serverSocketChannel = serverSocketChannel;
		this.selector = selector;
	}

	@Override
	public void run() {
		try{
			SocketChannel socketChannel = serverSocketChannel.accept();
			if(selector!=null){
				socketChannel.configureBlocking(false);
				SelectionKey selectionKey = socketChannel.register(selector,SelectionKey.OP_READ);
				selector.wakeup();
				selectionKey.attach(new TCPHandler(selectionKey,socketChannel));
			}
		}catch (Exception e){

		}
	}
}
