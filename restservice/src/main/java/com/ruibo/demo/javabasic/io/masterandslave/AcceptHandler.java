package com.ruibo.demo.javabasic.io.masterandslave;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class AcceptHandler implements Runnable {

	private final ServerSocketChannel serverSocketChannel;
	private final int cores = Runtime.getRuntime().availableProcessors();
	//	private final Selector selector;
	private final Selector[] selectors = new Selector[cores];

	private TCPSubReactor[] r = new TCPSubReactor[cores];
	private Thread[] t = new Thread[4];

	private int selIdex = 0;

	public AcceptHandler(ServerSocketChannel serverSocketChannel) throws IOException {
		this.serverSocketChannel = serverSocketChannel;
		for (int i = 0; i < cores; i++) {
			selectors[i] = Selector.open();
			//为selector分配reactor
			r[i] = new TCPSubReactor(selectors[i], i);
			t[i] = new Thread(r[i]);
			t[i].start();
		}
	}

	@Override
	public synchronized void run() {
		try {
			SocketChannel socketChannel = serverSocketChannel.accept();
			if (socketChannel != null) {
				socketChannel.configureBlocking(false);//设置为非阻塞
				r[selIdex].setRestart(true); //暂停
				selectors[selIdex].wakeup(); //使一个阻塞住的selector操作立即返回
				SelectionKey sk = socketChannel.register(selectors[selIdex], SelectionKey.OP_READ);
				selectors[selIdex].wakeup(); //使一个阻塞住的selector操作立即返回
				r[selIdex].setRestart(false); //重启线程
				sk.attach(new ReadHandler(sk, socketChannel));
				if (++selIdex == selectors.length) {
					selIdex = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
