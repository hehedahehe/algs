package com.ruibo.demo.jdk.concurency;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

/**
 * 通过临界区加锁实现并发控制
 *
 * 通过Wait-Notify实现并发控制
 */
public class WaitNotify {

    public static void main(String[] args) {
    }

    public static class Worker implements Runnable{
        Object o = new Object();


        public void workSelf(){
            System.out.println("working");
            try{
                o.wait();
            }catch (InterruptedException e){
                System.out.println("被中断 该怎么办，需要处理的");
            }
        }

        @Override
        public void run() {
//            workSyn();
        }
    }
}
