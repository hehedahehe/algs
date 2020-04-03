package com.ruibo.demo.math;

/**
 * 位运算
 */
public class BitCal {

    public static void main(String[] args) {
        int a = 100;
        System.out.println(Integer.toBinaryString(a));
        int b = 1;
        //1100100&1 = 0
        System.out.println((a & b)==0);
        //输出a终1的个数
        int count = 0;
        //发生溢出时b<0 运行时
        while (b > 0) {
            if ((a & b) > 0) {
                count++;
            } else {
                //
            }
            b = b << 1;
        }
        System.out.println(count);
    }
}
