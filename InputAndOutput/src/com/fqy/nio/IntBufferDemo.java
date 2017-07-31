package com.fqy.nio;

/*
 * Something to know about ByteBuffer:
 * flip(): is used to flip the buffer ByteBuffer from "reading"
 * (put ing) to "writing" (get ing): after a sequence of put s is used to fill
 * the ByteBuffer, flip will set the limit of the buffer to the current position and 
 * reset the position to zero. This has the effect of making a future get or write from the buffer
 * write all of what was put into the buffer and no more.
 * 
 */
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
	private static final int BSIZE = 1024;

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		IntBuffer ib = bb.asIntBuffer();
		// Store an array of int:
		ib.put(new int[] { 11, 42, 47, 99, 143, 811, 1016 });
		// Absolute location read aand write:
		System.out.println(ib.get(3));
		ib.put(3, 1811);
		// Setting a new limit before rewinding the buffer.
		ib.flip();
		// ib.rewind();
		// ib.clear(); // This method does not actually erase the data in the
		// buffer
		int j = 0;
		while (ib.hasRemaining()) {
			int i = ib.get();
			j++;
			System.out.println("The " + j + "th element--> " + i);
		}
	}

}
