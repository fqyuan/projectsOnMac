package com.fqyuan.enum1;

public enum SpaceShip {
	SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;
	public String toString() {
		// Because enum type is automatically inherited from java.lang.Enum
		String id = name();
		// return a substring that's a substring of the string.
		// From the index to the end of the string.
		String lower = id.substring(1).toLowerCase();
		// default version of the toString()
		return id.charAt(0) + lower;
	}

	public static void main(String[] args) {
		for (SpaceShip s : values()) {
			System.out.println(s);
		}
	}

}
