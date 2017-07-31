package com.fqyuan.con_singleton;

public class Test {
	public static void main(String[] args) throws Exception {

		Class<?> cl1 = Class.forName("com.fqyuan.con_singleton.Singleton");
		Class<?> cl2 = Class.forName("com.fqyuan.con_singleton.SingletonClass");

		System.out.println(cl1.getName());
		System.out.println(cl2.getName());
		// Eager初始化会在加载类时进行；而Lazy初始化会在第一次访问时
		Singleton.getInstance();
		SingletonClass.getInstance();
	}
}
