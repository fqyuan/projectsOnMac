package com.fqy.generator;

import java.util.LinkedHashSet;
import java.util.Set;

class Goverment implements Generator<String> {
	String[] foundation = ("strange women lying in ponds distributing "
			+ "swords is no basis for a system of goverment").split(" ");
	private int index;

	public String next() {
		return foundation[index++];
	}
}

public class CollectionDataTest {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>(new CollectionData<>(new Goverment(), 15));
		// using convenience method
		// What is a convenience method?
		// (object-oriented programming) A method created for convenience so
		// that some other, more complex task can be solved more easily.
		set.addAll(CollectionData.list(new Goverment(), 15));
		System.out.println(set);

	}

}
