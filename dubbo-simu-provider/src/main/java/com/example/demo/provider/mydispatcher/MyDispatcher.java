package com.example.demo.provider.mydispatcher;


import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.ChannelHandler;
import com.alibaba.dubbo.remoting.Dispatcher;
import com.alibaba.dubbo.remoting.transport.dispatcher.all.AllChannelHandler;

public class MyDispatcher implements Dispatcher {

    public static final String NAME = "mydispatcher";

    @Override
    public ChannelHandler dispatch(ChannelHandler handler, URL url) {
        return new AllChannelHandler(handler, url);
    }

}