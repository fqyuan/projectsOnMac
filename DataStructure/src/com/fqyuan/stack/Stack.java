package com.fqyuan.stack;

import java.lang.reflect.Array;

public class Stack<T> {
	private T[] stack;
	private int size;
	private int top;

	@SuppressWarnings("unchecked")
	public Stack() {
		top = -1;
		size = 50;
		stack = (T[]) new Object[50];
	}

	@SuppressWarnings("unchecked")
	public Stack(Class<T> cl) {
		top = -1;
		size = 50;
		stack = (T[]) Array.newInstance(cl, 50);
	}

	@SuppressWarnings("unchecked")
	public Stack(int size) {
		top = -1;
		this.size = size;
		stack = (T[]) new Object[size];
	}

	public boolean push(T item) {
		if (!isFull()) {
			stack[++top] = item;
			return true;
		}
		return false;
	}

	public T pop() {
		if (!isEmpty())
			return stack[top--];
		else {
			System.out.println("The stack is empty");
			return null;
		}
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return stack.length - 1 == top;
	}

}
