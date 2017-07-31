package com.fqy.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {

	public static void main(String[] args) throws IOException {
		// java.io.DataInputStream.DataInputStream(InputStream in)
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream("./src/com/fqy/io/TestEOF.java")));
		// Returns an estimate of the number of bytes
		while (in.available() != 0)
			System.out.print((char) in.readByte());
		in.close();
	}
}
