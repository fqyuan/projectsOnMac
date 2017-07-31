package com.fqy.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Persist {

	public static void main(String[] args) {
		Student stu = new Student(985, "fqy", 62.0);
		// Create a fileOutputStream to write to the file with a specified name
		try {
			FileOutputStream fout = new FileOutputStream("fout.txt");
			// Create an ObjectOutstream that writes to the specified
			// OutputStream
			ObjectOutputStream oos = new ObjectOutputStream(fout);

			// Write the specified object to the ObjectOutputStream
			oos.writeObject(stu);
			oos.flush();
			oos.close();
			System.out.println("success");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}