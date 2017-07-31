package com.fqy.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//{Args: ./src/com/fqy/nio/ChannelCopy.java /Users/fqyuan/Desktop/test.txt}
public class ChannelCopy {
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.out.println("arguments: sourcefile destfile");
			System.exit(1);
		}
		FileChannel in = new FileInputStream(args[0]).getChannel(), out = new FileOutputStream(args[1]).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while (in.read(buffer) != -1) {
			buffer.flip();// Prepare for writing
			out.write(buffer);
			buffer.clear(); // Prepare for reading
		}
	}

}
