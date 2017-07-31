package com.fqy.person;

import static com.fqy.util.Print.print;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MapTest {
	@Test
	public void test1() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");

		Set<Map.Entry<Integer, String>> set = map.entrySet();
		print(set);
	}

}
