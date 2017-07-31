package com.fqy.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
	// Throw exceptions to console:
	public static String read(String filename) throws IOException {
		// Reading input by lines:
		// java.io.BufferedReader.BufferedReader(Reader in)
		// java.io.FileReader.FileReader(String fileName) throws
		// FileNotFoundException
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		// String java.io.BufferedReader.readLine() throws IOException
		// Reads a line of text. A line is considered to be terminated by any
		// one of a line feed ('\n'), a carriage return ('\r'), or a carriage
		// return followed immediately by a linefeed.

		while ((s = in.readLine()) != null)
			sb.append(s + "\n");
		// void java.io.BufferedReader.close() throws IOException

		// Closes the stream and releases any system resources associated with
		// it. Once the stream has been closed, further read(), ready(), mark(),
		// reset(), or skip() invocations will throw an IOException. Closing a
		// previously closed stream has no effect.
		in.close();
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		System.out.println(read("./src/com/fqy/io/BufferedInputFile.java"));

	}

}
