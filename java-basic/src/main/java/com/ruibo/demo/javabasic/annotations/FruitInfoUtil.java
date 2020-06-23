package com.ruibo.demo.javabasic.annotations;

import java.lang.reflect.Field;

/**
 * 参考： https://blog.csdn.net/u012129558/article/details/78872283
 */
public class FruitInfoUtil {

	public static void getFruitInfo(Class<?> clazz) {

		String strFruitName = "水果名称";
		String stringFruitColor = "水果颜色";
		String strFruitProvider = "水果供应商";

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = field.getAnnotation(FruitName.class);
				strFruitName = strFruitName + fruitName.value();
				System.out.println(strFruitName);
			} else if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = field.getAnnotation(FruitColor.class);
				stringFruitColor = stringFruitColor + fruitColor.fruitColor();
				System.out.println(stringFruitColor);
			} else if (field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
				strFruitProvider = strFruitProvider + ":" + fruitProvider.id() + ":" + fruitProvider.name() + ":" + fruitProvider.address();
				System.out.println(strFruitProvider);
			}
		}

	}
}
