package com.ruibo;

public class SingleModel1 {
	private static SingleModel1 singleModel;

	public static synchronized SingleModel1 getInstance() {
		if (singleModel == null) {
			singleModel = new SingleModel1();
		}
		return singleModel;
	}
}
