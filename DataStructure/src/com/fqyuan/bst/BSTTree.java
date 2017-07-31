package com.fqyuan.bst;

import org.junit.Test;

public class BSTTree {
	private Node root;

	public class Node {
		private int data;
		private Node lchild;
		private Node rchild;

		public Node(int item) {
			data = item;
		}
	}

	public BSTTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int item) {
		if (root == null) {
			Node newNode = new Node(item);
			root = newNode;
			return;
		}

		// First find the position to insert.
		Node parent = root;
		Node currrent = root;
		while (currrent != null) {
			parent = currrent;
			if (item < currrent.data)
				currrent = currrent.lchild;
			else
				currrent = currrent.rchild;
		}
		// 'current' is the node to insert, 'parent' is the parent of 'current'.
		Node newNode = new Node(item);
		if (item < parent.data)
			parent.lchild = newNode;
		else
			parent.rchild = newNode;

	}

	// Choose the right max as the successor.
	private Node getSuccessor(Node node) {
		Node current = node.rchild;
		Node successor = null;
		// The node is to build a link with the successor.
		Node grand = null;
		while (current != null) {
			grand = successor;
			successor = current;
			current = current.lchild;
		}
		// After the loop, parent is the successor, grand is successor's father.
		if (successor != node.rchild) {
			grand.lchild = successor.rchild;
			successor.rchild = node.rchild;
		}

		return successor;
	}

	// 3 cases:
	public boolean delete(int item) {
		if (root == null)
			return false;
		// First of all, find the position to delete.
		Node current = root;
		Node parent = root;
		boolean isLeftChild = false;
		while (current.data != item) {
			parent = current;
			if (item < current.data) {
				current = current.lchild;
			} else
				current = current.rchild;
			if (current == null)
				return false;
		}
		if (parent.lchild.data == item)
			isLeftChild = true;
		else
			isLeftChild = false;

		// Case 1: if the node to be deleted is a leaf.
		if (current.lchild == null && current.rchild == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.lchild = null;
			} else {
				parent.rchild = null;
			}
		}
		// Case 2: if node to be deleted has a child.
		else if (current.lchild == null) {
			if (current == root) {
				root = current.rchild;
			} else if (isLeftChild) {
				parent.lchild = current.rchild;
			} else {
				parent.rchild = current.rchild;
			}
		} else if (current.rchild == null) {
			if (current == root) {
				root = current.lchild;
			} else if (isLeftChild) {
				parent.lchild = current.lchild;
			} else {
				parent.rchild = current.lchild;
			}
		}
		// Case 3: if node to be deleted has 2 children.
		else {
			// First find the successor: the leftMax or the rightMax node to
			// replace.
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.lchild = successor;
			} else {
				parent.rchild = successor;
			}
			successor.lchild = current.lchild;

		}

		return false;
	}

	public Node search(int item) {
		Node current = root;
		while (current.data != item) {
			if (item < current.data)
				current = current.lchild;
			else if (item > current.data)
				current = current.rchild;
			if (current == null)
				return null;
		}
		return current;
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.lchild);
		System.out.print(node.data + " ");
		inOrder(node.rchild);
	}

	@Test
	public void test() {
		BST<Integer> bst = new BST<>();
		int[] arr = { 1, 42, 29, 65, 22, 14, 6, 59, 71, 47, 20 };

		for (int i = 0; i < arr.length; i++) {
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
