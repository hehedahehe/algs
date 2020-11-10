package com.ruibo.demo.jvm;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

import sun.misc.PostVMInitHook;
import sun.misc.Unsafe;

/**
 *  -Xms:20M -XX:MaxDirectMemorySize=10M
 */
 public class NativeMemoryTrackingTest{

    public static final int _1MB = 1024*1024;

    public static void main(String[] args) throws Exception{
        // Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        // unsafeField.setAccessible(true);
        // Unsafe unsafe = (Unsafe) unsafeField.get(null);
        // System.out.println("begin....");
        // while(true){
        //     unsafe.allocateMemory(_1MB);
        //     System.out.println("1M...."+_1MB);
        // }

        ByteBuffer.allocateDirect(_1MB);
//        System.out.println(getDirectBufferPoolMBean().getMemoryUsed() / 1024.0 / 1024.0);
//        System.out.println(getNioBufferPool().getMemoryUsed() / 1024.0 / 1024.0);
    }
 }