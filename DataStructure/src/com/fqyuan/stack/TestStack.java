package com.fqyuan.stack;

import java.util.Random;

public class TestStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(10);
		Random random = new Random();
		while (!stack.isFull()) {
			int val = random.nextInt(100);
			System.out.print(val + " ");
			stack.push(val);
		}
		System.out.println();
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		System.out.println();
	}

}
