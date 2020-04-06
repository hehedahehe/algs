package com.ruibo.demo.jvm.jmm;


/**
 * 测试在并发访问条件下，
 * JMM针对volatile类型变量设定的特殊规则
 */
public class VolatileDemo {

    public static void main(String[] args) {

    }

    /**
     * 1. 是什么
     * 2. 为什么
     *
     * 1. 是什么。当一个变量被定义成volatile之后，它将具备两项特性：
     *   1.1 保证此变量对所有线程的可见性。这对于普通变量则无法做到。
     *      1.1.1 轻量级方案
     *   1.2 使用volatile变量的变量的第二个语义是禁止指令重排序优化。在同一个线程中的方法执行过程中无法感知到这点，这就是
     *   Java内存模型中描述的所谓“线程内表现为串行的语义”（表现为串行，但实际执行时不一定是按照原序执行）
     *      1.2.1 防止指令重排
     */

}
