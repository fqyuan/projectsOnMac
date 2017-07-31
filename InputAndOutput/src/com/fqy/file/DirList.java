package com.fqy.file;

import java.io.File;
import java.util.Arrays;

public class DirList {
	public static void main(String[] args) {
		File path = new File("./src/com/fqy/file");
		String[] list;
		if (args.length == 0)
			list = path.list();
		else
			// The accept is invoked by the list function!
			// also so called call-back
			list = path.list(new DirFilter(args[0]));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list)
			System.out.println(dirItem);
	}
}
