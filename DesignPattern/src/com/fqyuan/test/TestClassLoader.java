package com.fqyuan.test;

import java.util.HashMap;

import sun.net.spi.nameservice.dns.DNSNameService;

public class TestClassLoader {

	public static void main(String[] args) {
		System.out.println(HashMap.class.getClassLoader());
		System.out.println(DNSNameService.class.getClassLoader());
		System.out.println(TestClassLoader.class.getClassLoader());
	}
}