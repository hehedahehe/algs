package com.ruibo.demo.greeting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingController {

	private List<Greeting> objListCache = new ArrayList<>();

	@RequestMapping("/greeting")
	public Greeting greeting() {
		Greeting greeting = new Greeting();

		if (objListCache.size() >= 100000) {
			objListCache.clear();
		} else {
			objListCache.add(greeting);
		}
		System.out.println("====="+objListCache.size());

		return greeting;
	}
}
