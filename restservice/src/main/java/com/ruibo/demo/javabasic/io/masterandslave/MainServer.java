package com.ruibo.demo.javabasic.io.masterandslave;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class MainServer {

    public static void main(String[] args) {
        try {

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(123));

            //开启selector
			Selector acceptSelector = Selector.open();
			//注册channel
            serverSocketChannel.register(acceptSelector, SelectionKey.OP_ACCEPT,new AcceptHandler(serverSocketChannel));

            //为selector分配reactor
            TCPAcceptReactor reactor = new TCPAcceptReactor(acceptSelector);
            reactor.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
