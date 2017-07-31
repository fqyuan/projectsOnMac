package com.fqy.serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Depersist {

	public static void main(String[] args) {
		Student stu = null;
		try {
			FileInputStream fis = new FileInputStream("fout.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			stu = (Student) ois.readObject();

			ois.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Student class not found.");
			c.printStackTrace();
			return;
		}

		/*
		 * The value of the weight field was 62.0 when the object was
		 * serialized, but because the field is transient, this value was not
		 * sent to the output stream. The weight field of the deserialized
		 * Student object is 0.
		 */
		System.out.println(stu.getName() + " " + stu.getId() + " " + stu.getWeight());
	}
}