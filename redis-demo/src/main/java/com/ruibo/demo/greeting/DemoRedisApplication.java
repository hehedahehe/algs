package com.ruibo.demo.greeting;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * https://blog.csdn.net/u014042066/article/details/72778440
 */
@EnableDubbo
@SpringBootApplication
public class DemoRedisApplication {


	public static volatile boolean run = false;

	public static void main(String[] args) {
		SpringApplication.run(DemoRedisApplication.class, args);
	}
}
