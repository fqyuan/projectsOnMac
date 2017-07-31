package com.fqy.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

//The demonstration includes tons of comments.
public class BufferToText {
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws IOException {
		// FileChannel:A channel for reading, writing, mapping, and manipulating
		// a file.
		// getChannel(): Returns the unique FileChannel object associated with
		// this file output stream.
		FileChannel fc = new FileOutputStream("/Users/fqyuan/Desktop/Data/data2.txt").getChannel();
		// write():Writes a sequence of bytes to this channel from the given
		// buffer.
		// ByteBuffer java.nio.ByteBuffer.wrap(byte[] array)
		// Parameters:array The array that will back this buffer
		// Returns: The new byte buffer
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();

		// Read data from given channel
		fc = new FileInputStream("/Users/fqyuan/Desktop/Data/data2.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE); // Allocate a new
														// ByteBuffer
		fc.read(buffer); // Read a sequence of data into the given buffer
		// flip():After a sequence of channel-read or put operations, invoke
		// this
		// method to prepare for a sequence of channel-write or relative get
		// operations.
		buffer.flip();

		// Doesn't work:
		System.out.println(buffer.asCharBuffer());
		// Decoding using this system's default Charset:
		buffer.rewind(); // wind back to the beginning
		String encoding = System.getProperty("file.encoding");
		System.out.println("Decoding using " + encoding + ": " + Charset.forName(encoding).decode(buffer));
		// Or we could encode with something that will print:
		fc = new FileOutputStream("/Users/fqyuan/Desktop/Data/data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		fc.close();
		// Now try reading again:
		fc = new FileInputStream("/Users/fqyuan/Desktop/Data/data2.txt").getChannel();
		buffer.clear();
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());
		// Use a CharBuffer to write through
		fc = new FileOutputStream("/Users/fqyuan/Desktop/Data/data2.txt").getChannel();
		buffer = ByteBuffer.allocate(24); // More than needed
		buffer.asCharBuffer().put("Some text");
		fc.write(buffer);
		fc.close();
		// Read and display:
		fc = new FileInputStream("/Users/fqyuan/Desktop/Data/data2.txt").getChannel();
		buffer.clear();
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());
	}
}
