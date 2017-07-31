package com.fqy.queue;

import static com.fqy.util.Print.print;
import static com.fqy.util.Print.printnb;

public class DequeTest {
	static void fillTest(Deque<Integer> deque) {
		for (int i = 20; i < 27; i++)
			deque.addFirst(i);
		for (int i = 50; i < 55; i++)
			deque.addLast(i);

	}

	public static void main(String[] args) {
		Deque<Integer> di = new Deque<Integer>();
		fillTest(di);
		print(di);
		while (di.size() != 0)
			printnb(di.removeFirst() + " ");
		fillTest(di);
		print();
		while (di.size() != 0)
			printnb(di.removeLast() + " ");
	}

}
