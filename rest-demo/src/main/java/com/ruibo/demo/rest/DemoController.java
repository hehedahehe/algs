package com.ruibo.demo.rest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ruibo.demo.dubboproviderapi.IDemoProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


	@Reference
	private IDemoProviderService providerService;


	@GetMapping("/sayHi")
	public Object getHelloResponse(String name) {
		return providerService.SayHello(name);
	}
}
