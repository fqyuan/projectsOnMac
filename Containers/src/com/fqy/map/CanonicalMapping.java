package com.fqy.map;

import java.util.WeakHashMap;

class Element {
	private String ident;

	public Element(String id) {
		ident = id;
	}

	public String toString() {
		return ident;
	}

	public int hashCode() {
		return ident.hashCode();
	}

	public boolean equals(Object r) {
		return r instanceof Element && ident.equals(((Element) r).ident);
	}

	// Called by the garbage collector on an object when garbage collection
	// determines that there are no more references to the object. A subclass
	// overrides the finalize method to dispose of system resources or to
	// perform other cleanup
	protected void finalize() {
		System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
	}
}

class Key extends Element {
	public Key(String id) {
		super(id);
	}
}

class Value extends Element {
	public Value(String id) {
		super(id);
	}
}

public class CanonicalMapping {

	public static void main(String[] args) {
		int size = 1000;
		Key[] keys = new Key[size];
		WeakHashMap<Key, Value> map = new WeakHashMap<Key, Value>();
		for (int i = 0; i < size; i++) {
			Key k = new Key(Integer.toString(i));
			Value v = new Value(Integer.toString(i));
			if (i % 3 == 0)
				keys[i] = k; // Save as "real" reference
			map.put(k, v);
		}
		System.gc();
	}

}
// Running result:
