package com.fqy.standard_io;

import java.io.PrintWriter;

public class ChangeSystemOut {

	public static void main(String[] args) {
		// autoFlush A boolean; if true, the println, printf, or format methods
		// will flush the output buffer
		PrintWriter out = new PrintWriter(System.out, true);
		out.println("Hello, world");
	}

}
