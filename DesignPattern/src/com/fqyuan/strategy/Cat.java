package com.fqyuan.strategy;

public class Cat extends Animal {
	public Cat(String name) {
		setName(name);
		this.flyType = new FlyFast();
	}
}
