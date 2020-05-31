package com.ruibo.demo.javabasic.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * https://www.toutiao.com/i6818533429412364812
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
    }

    private final String MSG_1_FORMAT = "===============";
    private final String MSG_2_FORMAT = "Pool Size: %d";
    private final String MSG_3_FORMAT = "Active Thread: %d";
    private final String MSG_4_FORMAT = "Number of Tasks Completed: %d";
    private final String MSG_5_FORMAT = "Number of Tasks in Queue: %d";


    private void printStats(ThreadPoolExecutor pool){
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
            System.out.println(MSG_1_FORMAT);
            System.out.println(String.format(MSG_2_FORMAT, pool.getPoolSize()));
            System.out.println(String.format(MSG_3_FORMAT, pool.getActiveCount()));
            System.out.println(String.format(MSG_4_FORMAT, pool.getCompletedTaskCount()));
            System.out.println(String.format(MSG_5_FORMAT, pool.getQueue().size()));
            System.out.println(MSG_1_FORMAT);
        },0,1, TimeUnit.SECONDS);
    }
}
