package com.ruibo.demo.javabasic.io.masterandslave;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ReadHandler implements Runnable {

	private final SelectionKey selectionKey;
	private final SocketChannel socketChannel;

	private static final int THREAD_COUNTING = 10;
	private final static ThreadPoolExecutor pool = new ThreadPoolExecutor(THREAD_COUNTING, THREAD_COUNTING, 10, TimeUnit.SECONDS,
			new LinkedBlockingDeque<>());

	public ReadHandler(SelectionKey selectionKey, SocketChannel socketChannel) {
		this.selectionKey = selectionKey;
		this.socketChannel = socketChannel;
		pool.setMaximumPoolSize(32);
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
		try {
			int numBytes = socketChannel.read(buffer);
			if (numBytes == -1) {
				closeChannel();
				return;
			}

			String str = new String(arr);
			if ((str != null) && !str.equals(" ")) {
				pool.execute(new WorkThread(str));
			}
		} catch (Exception e) {
			e.printStackTrace();
			closeChannel();
		}

	}

	class WorkThread implements Runnable {
		private String str;

		public WorkThread(String str) {
			this.str = str;
		}

		@Override
		public void run() {
			try {
				process(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void send(String s) throws IOException {
		String returnRes = s + "'";
		ByteBuffer buffer = ByteBuffer.wrap(returnRes.getBytes());
		while (buffer.hasRemaining()) {
			socketChannel.write(buffer);
		}
		selectionKey.selector().wakeup();
	}

	private void process(String s) throws IOException {
	}
}
