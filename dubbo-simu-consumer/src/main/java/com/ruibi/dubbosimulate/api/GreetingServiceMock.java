package com.ruibi.dubbosimulate.api;


import com.ruibo.dubbo.simusdk.api.GreetingService;
import com.ruibo.dubbo.simusdk.api.PoJo;
import com.ruibo.dubbo.simusdk.api.Result;

public class GreetingServiceMock implements GreetingService {

	@Override
	public String sayHello(String name) {
		return "mock value";
	}

	@Override
	public Result<String> testGeneric(PoJo poJo) {
		return null;
	}
}
