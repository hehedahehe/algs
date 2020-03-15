package com.ruibo.demo;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

public class DemoController {

	private List<Greeting> objListCache = new ArrayList<>();

	@RequestMapping("/greeting")
	public Greeting greeting() {
		Greeting greeting = new Greeting();

		if (objListCache.size() >= 100000) {
			objListCache.clear();
		} else {

			objListCache.add(greeting);

		}

		return greeting;
	}
}
