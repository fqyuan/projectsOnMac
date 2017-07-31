package com.fqy.io;

import java.io.IOException;

public class DefaultIO {

	public static void main(String[] args) {
		System.out.println("Input a number: ");
		int num = 0;
		try {
			// return the ASCII code of the 1st character
			num = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Input data is: " + (char) num);
	}

}
