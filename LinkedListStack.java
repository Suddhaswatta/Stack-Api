package com.suddha;

import java.util.Iterator;

public class LinkedListStack<T> implements Iterable<T> {

	Node first = null;

	private class Node {
		T item;
		Node next;
	}

	public boolean isEmpty() {
		if (first == null)
			return true;
		else
			return false;
	}

	public void push(T item) {// Overflow doesn't happen in case of LinkedList
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}

	public T pop() {
		// Instead we can write
		/*
		 * String item = first.item; first = first.next; return item JAVA does garbage
		 * collection automatically in case of linked list
		 */

		// Loitering Code to take care of garbage || Loitering definition: references to
		// Object which no longer exists
		Node oldNode = first;
		T item = oldNode.item;
		first = oldNode.next;
		oldNode = null;
		return item;
	}

	private class StackIterator implements Iterator<T> {

		Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T item = current.item;
			current = current.next;
			return item;
		}

	}

	@Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}

}