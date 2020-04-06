package com.ruibo.demo.javabasic.concurency.thread;


public class ThreadDemo {

    /**
     * aaaaa run in Thread[main,5,main]
     * ===================
     * aaa run in Thread[main,5,main]
     * bbb run in Thread[main,5,main]
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.demoRunInMainThread();
        System.out.println("===================");
        threadDemo.demoRunInMainThreadTwo();
    }

    /**
     * Runnable是个可运行的资源，可以把它交给任何线程
     * 比如 new Thread() 、交给线程池、或者直接交给主线程
     * 但是直接交给主线程，在简单场景下感觉就像脱裤子放屁，多此一举，直接运行就完了。
     */
    public void demoRunInMainThread(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("aaaaa run in "+Thread.currentThread());
            }
        };

        runnable.run();
    }

    public void demoRunInMainThreadTwo(){
        Runnable runnableA = ()-> {
            System.out.println("aaa run in "+Thread.currentThread());
            Runnable aB =()->{
                     System.out.println("bbb run in "+Thread.currentThread());
                };
            aB.run();
        };
        runnableA.run();
    }
}
