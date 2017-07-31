package com.fqy.buffer;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("/Users/fqyuan/Desktop/Data/file.txt");
		// Attempt to acquire an exclusive lock on this channel's file
		FileLock fl = fos.getChannel().tryLock();
		// tryLock( ) is non-blocking. It tries to grab the lock, but if it
		// cannot (when some other process already holds the same lock and it is
		// not shared), it simply returns from the method call. lock( ) blocks
		// until the lock is acquired, or the thread that invoked lock( ) is
		// interrupted, or the channel on which the lock( ) method is called is
		// closed. A lock is released using FileLock.release( ).
		if (fl != null) {
			System.out.println("Locked File");
			TimeUnit.MILLISECONDS.sleep(100);
			fl.release();
			System.out.println("Released Lock");
		}
		fos.close();
	}
}
