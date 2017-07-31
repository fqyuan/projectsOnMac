package com.fqy.buffer;

import static com.fqy.util.Print.print;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {
	private static void symmetricScramble(CharBuffer buffer) {
		// Test whether there are any elements between the current position and
		// the limit.
		while (buffer.hasRemaining()) {
			// Set this buffer's mark at its position
			buffer.mark();
			// Relative get method. Reads the char at this buffer's current
			// position, and then increments the position.
			char c1 = buffer.get();
			char c2 = buffer.get();
			// Resets this buffer's position to the previously-marked position.
			buffer.reset();

			// Relative put method (optional operation).
			// Writes the given char into this buffer at the current position,
			// and then increments the position.
			buffer.put(c2).put(c1);
		}
	}

	public static void main(String[] args) {
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
		// Create a view of this ByteBuffer as a CharBuffer
		CharBuffer cb = bb.asCharBuffer();
		// dst.put(a) == dst.put(a, 0, a.length)
		cb.put(data);
		/// Rewind this buffer, the postion is set to zero and the mark is
		/// discarded.Invoke this method before a sequence of channel-write or
		/// get operations, assuming that the limit has already been set
		/// appropriately. For example:
		/*
		 * out.write(buf); // Write remaining data buf.rewind(); // Rewind
		 * buffer buf.get(array); // Copy data into array
		 */
		print(cb.rewind());

		// Abnormal output.
		symmetricScramble(cb);
		print(cb.rewind());
		// Normal output
		symmetricScramble(cb);
		print(cb.rewind());
		// Still abnormal output
		symmetricScramble(cb);
		print(cb.rewind());
	}

}
