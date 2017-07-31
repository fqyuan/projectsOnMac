package com.fqy.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

//This shows you how anonymous inner classes allow the creation of specific, one-off classes to solve problems.
public class DirList3 {

	public static void main(String[] args) {
		File path = new File("./src/com/fqy/file");
		String[] list;
		if (args.length == 0)
			list = path.list();
		else
			list = path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(args[0]);

				@Override
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches();
				}
			});

		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list)
			System.out.println(dirItem);
	}

}
