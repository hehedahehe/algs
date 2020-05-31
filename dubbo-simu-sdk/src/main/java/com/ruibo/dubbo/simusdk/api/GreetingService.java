package com.ruibo.dubbo.simusdk.api;

public interface GreetingService {
	String sayHello(String name);
	
	Result<String> testGeneric(PoJo poJo);
}
