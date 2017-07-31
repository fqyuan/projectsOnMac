package com.fqy.generic;

public class GenericClass<T> {
	private T t;

	public void add(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public static void main(String[] args) {
		GenericClass<Integer> intClass = new GenericClass<>();
		GenericClass<String> strClass = new GenericClass<>();

		intClass.add(10);
		strClass.add("Hello sdy");

		System.out.println("Integer value: " + intClass.get());
		System.out.println("String value: " + strClass.get());
	}

}
