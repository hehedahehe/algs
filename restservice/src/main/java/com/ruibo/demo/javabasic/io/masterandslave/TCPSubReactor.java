package com.ruibo.demo.javabasic.io.masterandslave;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TCPSubReactor implements Runnable {

	private final ServerSocketChannel serverSocketChannel;
	private final Selector selector;
	private int num;
	private volatile boolean restart;

	public TCPSubReactor(Selector selector, ServerSocketChannel serverSocketChannel, int num) throws IOException {
		this.selector = selector;
		this.serverSocketChannel = serverSocketChannel;
		this.num = num;
	}

	public void setRestart(boolean restart) {
		this.restart = restart;
	}

	@Override
	public void run() {
		while (!Thread.interrupted() && !restart) {
			ServerSocket serverSocket = serverSocketChannel.socket();
			//监控事件发生
			//处理事件
			try {
				//无事件发生 continue
				if (selector.select() == 0) {
					continue;
				}
			} catch (Exception e) {

			}

			//获取感兴趣的事件的集合
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> it = selectionKeys.iterator();
			while (it.hasNext()) {
				SelectionKey selectionKey = it.next();
				dispatch(selectionKey);
				it.remove();
			}

		}
	}

	private void dispatch(SelectionKey selectionKey) {
		//取出附加对象 根据附加对象判断是什么事件 调用不同附加对象的Run方法
		//请注意这个附加对象
		//如果是接受客户端链接的话  这里取出的附加对象就是Acceptor 调用的肯定也是Acceptor的run方法
		//如果是已经连接上来的客户端发来数据，则是读事件 那么这里取出的附加对象就是TCPHandler,
		//TCPHandler哪里来的请往下看
		//new Acceptor(selector,scc)
//		Selector selector = selectionKey.selector();
//		SelectableChannel selectableChannel = selectionKey.channel();
		Runnable r = (Runnable) selectionKey.attachment();
		if (r != null) {
			r.run();
		}
	}
}
