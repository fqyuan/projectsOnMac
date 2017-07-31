package com.fqy.map;

//Both equals and hashCode() method has been overriden
public class Groundhog2 extends Groundhog {
	public Groundhog2(int n) {
		super(n);
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Groundhog2 && (number == ((Groundhog) o).number);
	}
}
