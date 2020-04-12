package com.example.demo.provider;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.rpc.RpcContext;
import com.ruibo.dubbo.simusdk.api.GreetingService;
import com.ruibo.dubbo.simusdk.api.PoJo;
import com.ruibo.dubbo.simusdk.api.Result;

import java.io.IOException;


public class GreetingServiceImpl implements GreetingService {

	@Override
	public String sayHello(String name) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello " + name + " " + RpcContext.getContext().getAttachment("company");
	}

	@Override
	public Result<String> testGeneric(PoJo poJo) {
		Result<String> result = new Result<String>();
		result.setSucess(true);
		try {
			result.setData(JSON.json(poJo));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}    