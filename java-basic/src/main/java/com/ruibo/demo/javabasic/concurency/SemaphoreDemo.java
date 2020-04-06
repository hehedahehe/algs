package com.ruibo.demo.javabasic.concurency;

import com.ruibo.demo.javabasic.TimeTools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    // 排队总人数（请求总数）
    public static int clientTotal = 10;

    // 可同时受理业务的窗口数量（同时并发执行的线程数）
    public static int threadTotal = 2;


    public static void main(String[] args) throws Exception{
        System.out.println("begin=="+TimeTools.getTime());
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        //permits +3
//        semaphore.release(1);
//        semaphore.release(1);
//        semaphore.release(1);
        System.out.println("availablePermits==="+semaphore.availablePermits());
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    System.out.println(count+"号顾客开始尝试获取 "+ TimeTools.getTime());
                    //获取
                    semaphore.acquire(1);
                    System.out.println(count+"号顾客开始尝试获取成功 "+ TimeTools.getTime());
                    resolve(count);
                    //释放
                    semaphore.release(1);
                    //permits + 5 由于没有做限制，所以用户在编程时，需要遵守一定的规则，“拿一个permit，用完还一个permit”
//                    semaphore.release(1);
//                    semaphore.release(1);
//                    semaphore.release(1);
//                    semaphore.release(1);
//                    semaphore.release(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //执行完业务逻辑，计数减一
                countDownLatch.countDown();
            });
        }
        //不断检测aqs state是否为0 一旦为0 则返回，当前线程继续执行。
        //思想是：主线程不断check aqs的状态，一旦满足条件，则放行。
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("end===="+TimeTools.getTime());

    }

    private static void resolve(int i) throws InterruptedException {
//        System.out.println("服务号{}，受理业务中。。。"+i);
        Thread.sleep(2000);
    }
}
