package com.ruibo.demo.javabasic;

public class SingleModel3 {
	//volatile
	private volatile static SingleModel3 singleModel;

	public static SingleModel3 getInstance() {
		if (singleModel == null) {
			synchronized (SingleModel3.class) {
				if (singleModel == null) { //double check lock
					singleModel = new SingleModel3();
				}
			}
		}
		return singleModel;
	}

	public static void main(String[] args) {
		SingleModel3 singleModel3 = SingleModel3.getInstance();
	}
}
