package com.fqyuan.con_singleton;

class Singleton {
	private static final Singleton INSTANCE = new Singleton();

	private Singleton() {
		System.out.println("Eager Constructor.");
	}

	public static Singleton getInstance() {
		return INSTANCE;
	}

}
