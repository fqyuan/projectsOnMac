package com.fqyuan.con_singleton;

public class SingletonClass {
	private static volatile SingletonClass INSTANCE = null;

	// private constructor.
	private SingletonClass() {
		System.out.println("Lazy Constructor");
	}

	// static method to get the instance
	public static SingletonClass getInstance() {
		if (INSTANCE == null) { // First time check.
			synchronized (SingletonClass.class) {
				if (INSTANCE == null) { // Second time check.
					INSTANCE = new SingletonClass();
				}
			}
		}
		return INSTANCE;
	}
}
