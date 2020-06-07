package com.ruibo.demo.javabasic.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 不建议是使用Excecutors提供的两种快捷的线程池
 * 1. 我们需要根据自己的场景、并发情况来评估线程池的几个核心参数，包括核心线程数、最大线程数、
 * 线程回收策略、工作队列的类型，以及拒绝策略，确保线程池的工作行为符合需求，一般都需要设置有界的
 * 工作队列和可控的线程数
 * 2. 任何时候，都应该为自定义的线程池指定有意义的名称，以方便排查问题。当出现线程数暴增、线程死锁、线程占用
 * 大量CPU、线程执行出现异常等问题时，我们往往会抓取线程栈。此时，有意义的线程名称，就可以方便我们定位问题。
 * 3. 建议使用一些监控手段来观察线程池的状态。线程池这个组件往往会表现地任劳任怨、默默无闻，除非时出现了拒绝策略
 * ，否则压力再大都不会抛出一个异常。如果我们能提前观察到线程池队列的积压，或者线程数量的快速膨胀，往往可以提早发现
 * 并解决问题。
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
