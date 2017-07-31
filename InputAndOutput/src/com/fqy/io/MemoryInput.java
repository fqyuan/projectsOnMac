package com.fqy.io;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {

	public static void main(String[] args) throws IOException {
		// A character stream whose source is a string.
		StringReader in = new StringReader(BufferedInputFile.read("./src/com/fqy/io/MemoryInput.java"));
		int c;

		// int java.io.StringReader.read() throws IOException

		// Reads a single character.
		// Overrides: read() in Reader
		// Returns:
		// The character read, or -1 if the end of the stream has been reached
		while ((c = in.read()) != -1)
			System.out.print((char) c);
	}

}
