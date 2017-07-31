package com.fqy.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ThawAlien {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("/Users/fqyuan/Desktop/X.file")));
		Object mystery = in.readObject();
		System.out.println(mystery.getClass());
	}
}
