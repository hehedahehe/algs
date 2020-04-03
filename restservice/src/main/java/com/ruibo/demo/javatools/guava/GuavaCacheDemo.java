package com.ruibo.demo.javatools.guava;

//import com.google.common.cache.Cache;
//import com.google.common.cache.CacheBuilder;

/**
 * https://www.cnblogs.com/fnlingnzb-learner/p/11022152.html
 */
public class GuavaCacheDemo {

//    public static void main(String[] args) {
//        Cache<String, Object> cache = CacheBuilder.newBuilder()
//                .maximumSize(2)
//                //可以通过weakKeys和weakValues方法指定Cache只保存对缓存记录key和value的弱引用。
//                // 这样当没有其他强引用指向key和value时，key和value对象就会被垃圾回收器回收。
//                .weakValues()
//                .build();
//        Object value = new Object();
//        cache.put("key1", value);
//
//        value = new Object();//原对象不再有强引用
//        System.gc();
//        System.out.println(cache.getIfPresent("key1"));
//    }
}
