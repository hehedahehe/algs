package com.ruibo.demo.rest;

import com.ruibo.demo.dubboproviderapi.IDemoProviderService;
import org.apache.dubbo.config.annotation.Reference;
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
