package com.ruibo.dubbo.simusdk.api;

import java.util.concurrent.CompletableFuture;
 
public interface GrettingServiceAsync {
	CompletableFuture<String> sayHello(String name);
}