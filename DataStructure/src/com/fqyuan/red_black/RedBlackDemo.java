package com.fqyuan.red_black;

public class RedBlackDemo {

	public static void main(String[] args) {
		RedBlackTree rbTree = new RedBlackTree();
		int[] arr = { 8, 11, 14, 18, 22, 23, 31, 37, 41, 47, 60, 74, 84, 87, 88, 97, 99 };
		for (int val : arr) {
			rbTree.insert(val);
		}
		rbTree.inOrder();
		if (rbTree.search(4))
			System.out.println("Find 45");
		else
			System.out.println("45 not found.");
	}

}