package com.fqyuan.strategy;

public interface Flys {
	public String fly();
}

class FlyFast implements Flys {
	@Override
	public String fly() {
		return "Flying fast!";
	}
}

class FlySlow implements Flys {
	@Override
	public String fly() {
		return "Flying slowly!";
	}
}

class NotFly implements Flys {
	@Override
	public String fly() {
		return "Unable to fly!";
	}
}