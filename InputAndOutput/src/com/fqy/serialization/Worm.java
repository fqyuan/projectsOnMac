package com.fqy.serialization;

import static com.fqy.util.Print.print;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

class Data implements Serializable {
	private int n;

	public Data(int n) {
		this.n = n;
	}

	public String toString() {
		return Integer.toString(n);
	}
}

public class Worm implements Serializable {
	private static Random rand = new Random(47);
	private Data[] d = { new Data(rand.nextInt(10)), new Data(rand.nextInt(10)), new Data(rand.nextInt(10)) };
	private Worm next;
	private char c;

	// Value of i == number of segments
	// Another example of recursion function
	public Worm(int i, char x) {
		c = x;
		if (--i > 0)
			next = new Worm(i, (char) (x + 1));
		print("Worm cosntructor: " + i);
	}

	public Worm() {
		print("Default constructor");
	}

	public String toString() {
		StringBuilder result = new StringBuilder(":");
		result.append(c);
		result.append("(");
		for (Data data : d)
			result.append(data);
		result.append(")");
		if (next != null)
			result.append(next);
		return result.toString();
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Worm w = new Worm(6, 'a');
		print("w= " + w);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/fqyuan/Desktop/worm.out"));
		out.writeObject("Worm storage\n");
		out.writeObject(w);
		out.close(); // Also flushes output

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/fqyuan/Desktop/worm.out"));
		String s = (String) in.readObject();
		Worm w2 = (Worm) in.readObject();
		print(s + "w2 = " + w2);

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(bout);
		out2.writeObject("Worm storage\n");
		out2.writeObject(w);
		out2.flush();

		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
		s = (String) in2.readObject();
		Worm w3 = (Worm) in2.readObject();
		print(s + "w3 = " + w3);
	}
}
