package com.ruibo.demo.javabasic.concurency.syndemo;

public class SynAndVolatileDemo {
	/**
	 *  0 invokestatic #2 <com/ruibo/jdk/concurency/SynAndVolatileDemo.doA>
	 *  3 ldc #3 <com/ruibo/jdk/concurency/SynAndVolatileDemo>
	 *  5 dup
	 *  6 astore_1
	 *  7 monitorenter
	 *  8 invokestatic #4 <com/ruibo/jdk/concurency/SynAndVolatileDemo.doB>
	 * 11 aload_1
	 * 12 monitorexit
	 * 13 goto 21 (+8)
	 * 16 astore_2
	 * 17 aload_1
	 * 18 monitorexit
	 * 19 aload_2
	 * 20 athrow
	 * 21 return
	 */
    private static int a = 0;
	public static void main(String[] args) {
		SynAndVolatileDemo demo = new SynAndVolatileDemo();
		demo.doA();
		synchronized (SynAndVolatileDemo.class){
			demo.doB();
		}
	}

	public  void doA() {
		a = 1;
	}

	public  synchronized void doB() {
		a++;
	}

}

