package com.fqy.container;

public abstract class Test<C> {
	String name;

	public Test(String name) {
		this.name = name;
	}

	// Override this method for different tests. Return actual number
	// Of repetitions of test.
	abstract int test(C contanier, TestParam tp);
}
