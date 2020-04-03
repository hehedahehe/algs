package com.ruibo.demo.javademo;

public class SingleModel2 {
	private static SingleModel2 singleModel;

	public static SingleModel2 getInstance() {
		if (singleModel == null) {
			synchronized (SingleModel2.class) {
				if (singleModel == null) {
					singleModel = new SingleModel2();
				}
			}
		}
		return singleModel;
	}
}
