package com.fqy.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

//{Args: TransferTo.java TransferTo.txt}
public class TransferTo {

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.out.println("arguments: sourcefile destfile");
			System.exit(1);
		}
		FileChannel in = new FileInputStream(args[0]).getChannel(), out = new FileOutputStream(args[1]).getChannel();
		// Transfers bytes from this channel's file to the given writable byte
		// channel.

		in.transferTo(0, in.size(), out);
		// Or:
		// out.transferFrom(in, 0, in.size());

	}

}
