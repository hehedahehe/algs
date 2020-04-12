package com.ruibo.demo.rest;

import com.google.common.collect.ImmutableMap;
import com.ruibo.demo.dubboproviderapi.IDemoProviderService;
import com.ruibo.dubbo.simusdk.api.GreetingService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


	@Reference
	private IDemoProviderService providerService;
	@Reference
	private GreetingService greetingService;


	@GetMapping("/sayHi")
	public Object getHelloResponse(String name) {
		String resFromProvider =  providerService.SayHello(name);
		String resFromProviderTwo =  greetingService.sayHello(name);
		return ImmutableMap.of(
				"resFromProvider",resFromProvider,
				"resFromProviderTwo",resFromProviderTwo

		);
	}
}
