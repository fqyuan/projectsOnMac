package com.fqyuan.bst;

public class BSTDemo {

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		int[] arr = { 42, 29, 65, 22, 14, 6, 59, 71, 47, 20 };

		for (int i = 0; i < 10; i++) {
			bst.insert(arr[i]);
		}
		bst.inOrder();

		if (bst.search(10))
			System.out.println("\nFind 10");
		else
			System.out.println("\n10 not found.");

		// Insert a new element: 18
		bst.insert(18);
		bst.inOrder();
		// Delete an element:
		System.out.println();
		bst.delete(29);
		bst.inOrder();

	}

}
