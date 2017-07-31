package com.fqy.person;

import java.util.HashMap;
import java.util.Map;

public class Person {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Person && (((Person) o).name == this.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name == null ? 0 : name.hashCode() + age;
		return result;

	}

	@Override
	public String toString() {
		return "Person " + name + " " + age;
	}

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Map<Person, Integer> map = new HashMap<Person, Integer>();

		p1.setAge(22);
		p1.setName("A");
		p2.setAge(23);
		p2.setName("A");
		p3.setAge(24);
		p3.setName("C");

		map.put(p1, 1);
		map.put(p2, 2);
		map.put(p3, 3);
		System.out.println(map);
	}
}
