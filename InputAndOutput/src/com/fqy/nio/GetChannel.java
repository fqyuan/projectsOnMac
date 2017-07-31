package com.fqy.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws Exception {
		// Write a file:
		FileChannel fc = new FileOutputStream("/Users/fqyuan/Desktop/data.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text ".getBytes()));
		fc.close();
		// Add to the end of the file:
		fc = new RandomAccessFile("/Users/fqyuan/Desktop/data.txt", "rw").getChannel();
		// Sets this channel's file location
		fc.position(fc.size()); // Move to the end
		// fc.size() returns the current size of this channel's file
		// Wraps a byte array into a buffer.
		fc.write(ByteBuffer.wrap("Some more".getBytes()));
		fc.close();

		// Read the file:
		fc = new FileInputStream("/Users/fqyuan/Desktop/data.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		// Reads a sequence of bytes from this channel into the given buffer.
		fc.read(buff);
		// flip the buffer. The limit is set to the current location and then
		// the position is set to zero.

		buff.flip();
		while (buff.hasRemaining())
			System.out.print((char) buff.get());

	}

}
