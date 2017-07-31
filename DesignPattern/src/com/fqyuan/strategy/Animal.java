package com.fqyuan.strategy;

public class Animal {
	private String name;
	public Flys flyType;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// The super class pushes off the responsibility for flying to flyType, an
	// interface instance
	public String tryToFly() {
		return flyType.fly();
	}

	// We can add the method to change the Flys type dynamically
	public void setFlyType(Flys newFlyType) {
		flyType = newFlyType;
	}

	@Override
	public String toString() {
		return name;
	}

	/*
	 * Bad, you don't want to add methods to the super class. You need to
	 * separate what is different from subclass and the super class.
	 */
	// public void fly(){
	// System.out.println("I'm flying!");
	// }
}
