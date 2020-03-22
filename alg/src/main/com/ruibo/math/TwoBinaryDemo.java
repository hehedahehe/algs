package com.ruibo.math;

/**
 * 二进制运算
 */
public class TwoBinaryDemo {

    public static void main(String[] args) {
        /**
         * java int类型是4个字节 也就是32位
         */
        /**
         * 采用16进制表示 一个数字占4位 2^4=16 那么两个16进制数字占8位 也就是一个字节
         */
        int c = 18;
        int a = 0x12;
        int b = 0x00000012;
        // 18 = 2^4+2
        int d = 0b00000000000000000000000000010010;
        //高位的0可以省略
        int e = 0b10010;
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
        System.out.println(e);
        System.out.println(e);


        //测试负数 2^3+2
        /**
         * 1.先将-5的绝对值转换成二进制，即为0000 0101；
         *
         * 2.然后求该二进制的反码，即为 1111 1010；
         *
         * 3.最后将反码加1，即为：1111 1011
         */
        int f = -10;
        int f1 = ~0b00000000000000000000000000001010+1;
        System.out.println(f);
        System.out.println(f1);
        System.out.println(" //测试移位 正数");
        /**
         * 正数
         * 左移位 高位多余的0舍去，低位补0。考虑溢出问题。
         * 比如通过左移位正数表示成 取反的效果 变成了负数
         */
        //测试移位
        int a1 = 10;
        int a2 = a1 << 1; //a1*2
        int a3 = a1 >> 1; //a1/2
        int a4 = a1<<3; //a1*8
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);

        //以二进制输出Integer
        // 最大值 max= 0111 1111 1111 1111 1111 1111 1111 1111  2^31-1
        // 最小值 min= 1000 0000 0000 0000 0000 0000 0000 0000  -2                 min=~max+1
        System.out.println("以二进制输出Integer最大值"+Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("以二进制输出Integer最小值"+Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println("以16进制输出Integer最大值"+Integer.toHexString(Integer.MAX_VALUE));
        int a5 = (int)Math.pow(2,31);
        double a6 = Math.pow(2,31);
        long a7 = (long)Math.pow(2,31);
        System.out.println(a5);
        System.out.println(a6);
        System.out.println(a7);

        System.out.println(a5==Integer.MAX_VALUE);
    }
}