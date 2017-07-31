package com.fqy.person;

public class HashTest {
	public static void main(String[] args) {
		String[] str = { "Hello", "Hello", "Hello", "" };
		System.out.println(str[0].hashCode());
		System.out.println(str[1].hashCode());
		System.out.println(str[2].hashCode());
		System.out.println(str[3].hashCode());
		// From the result, we can see that they are of the same hashCode,which
		// means that they are of the same object in memory.
	}
}
