package com.ruibo.demo.javabasic.annotations;

public class Apple {
	/**
	 * 注解的本质是接口
	 * <p>
	 * 接口的本质是继承
	 *
	 * @Target(ElementType.FIELD) 标记了继承发生的对象：字段、方法、类、参数等等
	 *
	 *
	 */

	/**
	 * 必须是constant 因为接口中只允许声明常量
	 * 因为接口的初始化是发生在"类加载阶段"
	 *
	 * 而普通成员变量的使用则是发生在"初始化阶段"
	 */
	private static final String defaultName = "红富士";
	private  String defaultName2 = "红富士";

	@FruitName(defaultName)
//	@FruitName(defaultName=defaultName2)
	private String appleName;

	@FruitColor(fruitColor = FruitColor.Color.RED)
	private String appleColor;

	@FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省AAA")
	private String appleProvider;


	public String getAppleName() {
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	public String getAppleProvider() {
		return appleProvider;
	}

	public void setAppleProvider(String appleProvider) {
		this.appleProvider = appleProvider;
	}
}
