package com.ruibo.demo.greeting;

import org.junit.Before;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class SingleDemo {

    private RedissonClient redissonClient = null;

    @Before
    public void init() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("47.254.86.154:6377");
        redissonClient = Redisson.create(config);
    }

    @Test
    public void testCompareAndSet() {
        RAtomicLong longObject = redissonClient.getAtomicLong("myLong");
        longObject.addAndGet(3);
        // sync way
        longObject.compareAndSet(3, 401);
        // async way
//        longObject.compareAndSetAsync(3, 401);
        System.out.println("====>" + longObject);
        //        RedissonReactiveClient client = Redisson.createReactive(config);
        //        RAtomicLongReactive longObject = client.getAtomicLong('myLong');
        //// reactive way
        //        longObject.compareAndSet(3, 401);
    }
}
