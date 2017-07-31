package com.fqyuan.strategy;

/*
 * 设计模式出现的缘由？
 * 代码的可读性，可维护性，减少代码的冗余度.
 * 2条重要原则：
 * 1). 能使用composition的尽量不要用inheritance.
 * 2). 能使用Interface的尽量不要用具体的class.
 */
public class StrategyDemo {

	public static void main(String[] args) {
		Animal dog = new Dog("Rick");
		Cat cat = new Cat("Kitty");

		System.out.println(dog + " " + dog.tryToFly());
		System.out.println(cat + " " + cat.tryToFly());
		dog.setFlyType(new FlySlow());
		System.out.println(dog + " " + dog.tryToFly());
	}

}
