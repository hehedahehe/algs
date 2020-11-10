package com.ruibo.demo.greeting;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
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
import java.util.concurrent.TimeUnit;

/**
 * https://blog.csdn.net/u014042066/article/details/72778440
 */
@EnableDubbo
@SpringBootApplication
public class DemoRedisApplication {


	public static volatile boolean run = false;

	public static void main(String[] args) {
		SpringApplication.run(DemoRedisApplication.class, args);
		Config config = new Config();
		config.useSentinelServers()
				.addSentinelAddress("127.0.0.1:6369","127.0.0.1:6379", "127.0.0.1:6389")
				.setMasterName("masterName")
				.setPassword("password")
				.setDatabase(0);
		RedissonClient redissonClient = Redisson.create(config);
// 还可以getFairLock(), getReadWriteLock()
		RLock redLock = redissonClient.getLock("REDLOCK_KEY");
		boolean isLock;
		try {
			isLock = redLock.tryLock();
			// 500ms拿不到锁, 就认为获取锁失败。10000ms即10s是锁失效时间。
			isLock = redLock.tryLock(500, 10000, TimeUnit.MILLISECONDS);
			if (isLock) {
				//TODO if get lock success, do something;
			}
		} catch (Exception e) {
		} finally {
			// 无论如何, 最后都要解锁
			redLock.unlock();
		}
	}
}
