package com.ruibo.demo.javabasic.io.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TCPHandler implements Runnable {

	private final SelectionKey selectionKey;
	private final SocketChannel socketChannel;

	public TCPHandler(SelectionKey selectionKey, SocketChannel socketChannel) {
		this.selectionKey = selectionKey;
		this.socketChannel = socketChannel;
	}

	@Override
	public void run() {
		try {
			read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeChannel() {
		try {
			selectionKey.cancel();
			socketChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private synchronized void read() throws IOException {
		byte[] arr = new byte[1024];
		ByteBuffer buffer = ByteBuffer.wrap(arr);

		int numBytes = socketChannel.read(buffer);
		if (numBytes == -1) {
			closeChannel();
			return;
		}
		String str = new String(arr);
		if ((str != null) && !str.equals(" ")) {
			process(str);
			send(str);
			selectionKey.selector().wakeup();
		}
	}

	private void send(String s) throws IOException{
		String returnRes = s+"'";
		ByteBuffer buffer = ByteBuffer.wrap(returnRes.getBytes());
		while (buffer.hasRemaining()){
			socketChannel.write(buffer);
		}
		selectionKey.selector().wakeup();
	}

	private void process(String s) {
	}
}
