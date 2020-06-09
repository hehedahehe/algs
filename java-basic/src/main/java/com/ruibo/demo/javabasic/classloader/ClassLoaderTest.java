package com.ruibo.demo.javabasic.classloader;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 */
public class ClassLoaderTest {
	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//		new ClassLoaderTest().test();
		new ClassLoaderTest().test2();
	}


	public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		//新建一个类加载器
		MyClassLoader cl = new MyClassLoader("myClassLoader");
		//加载类，得到Class对象
		Class<?> clazz = cl.loadClass("com.ruibo.demo.javabasic.classloader.Animal");
		//得到类的实例
		Animal animal = (Animal) clazz.newInstance();
		animal.say();

		Animal myAnimal = new Animal();
		myAnimal.say();
		boolean equalClass = myAnimal.getClass().equals(animal.getClass());
		System.out.println(equalClass);

		System.out.println(myAnimal instanceof com.ruibo.demo.javabasic.classloader.Animal);
	}

	public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		//新建一个类加载器
		MyClassLoader cl = new MyClassLoader("myClassLoader");
		//加载类，得到Class对象
		Object o = cl.loadClass("com.ruibo.demo.javabasic.classloader.Animal").newInstance();
		System.out.println(o instanceof com.ruibo.demo.javabasic.classloader.Animal);
	}



	class MyClassLoader extends ClassLoader {
		//类加载器的名称
		private String name;
		//类存放的路径
		private String path = "/Users/liruibo/Documents/code/github/algs/restservice/target/classes/com/ruibo/demo/classloader/";

		MyClassLoader(String name) {
			this.name = name;
		}

		MyClassLoader(ClassLoader parent, String name) {
			super(parent);
			this.name = name;
		}

		/**
		 * 重写findClass方法
		 */
		@Override
		public Class<?> findClass(String name) {
			byte[] data = loadClassData(name);
			return this.defineClass(name, data, 0, data.length);
		}

		public byte[] loadClassData(String name) {
			try {
				FileInputStream is = new FileInputStream(new File(path + name + ".class"));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				int b = 0;
				while ((b = is.read()) != -1) {
					baos.write(b);
				}
				return baos.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}
}
