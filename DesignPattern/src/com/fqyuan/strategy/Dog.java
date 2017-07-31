package com.fqyuan.strategy;

public class Dog extends Animal {
	public Dog(String name) {
		this.setName(name);
		/*
		 * We set the interface polymorphically. Here we set the dog disability
		 * to fly.
		 */
		flyType = new NotFly();
	}

	/*
	 * Bad! You can override the fly() method, but we're breaking the rule that
	 * we need to abstract what is different to the subclasses.
	 * 即：子类的方法尽量保持一般是和其他子类方法不同，这样可以减少代码的冗余度。
	 */
	// public void fly() {
	// System.out.println("I can't fly!");
	// }
}
