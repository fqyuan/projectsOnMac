package com.fqyuan.enum1;

import static com.fqyuan.utils.Print.print;
import static com.fqyuan.utils.Print.printnb;

public class EnumClass {

	public static void main(String[] args) {
		for (Shrubbery s : Shrubbery.values()) {
			print(s + " ordinal: " + s.ordinal());
			printnb(s.compareTo(Shrubbery.CRAWLING) + " ");
			printnb(s.equals(Shrubbery.CRAWLING) + " ");
			print(s == Shrubbery.CRAWLING);
			// Returns the Class object corresponding to this enum constant's
			// enum type.
			print(s.getDeclaringClass());
			print(s.name());
			print("-----------------");
		}
		// Produce an enum value from a string name:
		for (String s : "HANGING CRAWLING GROUND".split(" ")) {
			// Returns the enum constant of the specified enum type with the
			// specified name.
			Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
			print(shrub);
		}
	}

}
