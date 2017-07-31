package com.fqy.map;

import static com.fqy.util.Print.print;

import com.fqy.generator.CountingGenerator;
import com.fqy.generator.RandomGenerator;

public class MapDataTest {

	public static void main(String[] args) {
		// Pair Generator
		print(MapData.map(new Letters(), 11));
		// Two separate generators:
		print(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8));
		// A key Generator and a single value:
		print(MapData.map(new CountingGenerator.Character(), "Value", 6));
		// A Iterable and a value Generator:
		print(MapData.map(new Letters(), new RandomGenerator.String(3)));
		// A Iterable and a single value:
		print(MapData.map(new Letters(), "Pop"));
	}

}
