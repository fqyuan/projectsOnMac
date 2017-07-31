package com.fqy.generic;

public class GeMethod {
	// Determine the largest of three Comparable objects
	public static <T extends Comparable<T>> T maxInThree(T x, T y, T z) {
		T max = x;
		if (y.compareTo(max) > 0)
			max = y;
		if (z.compareTo(max) > 0)
			max = z;
		return max;
	}

	public static void main(String[] args) {
		System.out.printf("Max of %d %d %d is %d\n", 3, 4, 5, maxInThree(3, 4, 5));
		System.out.printf("Max of %.1f %.1f %.1f is %.1f\n", 8.9, 4.7, 5.6, maxInThree(8.9, 4.7, 5.6));
		System.out.printf("Max of %s %s %s is %s\n", "pear", "apple", "banana", maxInThree("pear", "apple", "banana"));

	}
}
