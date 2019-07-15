package com.suddha;

import java.util.Iterator;

public class ArrayStack <T> implements Iterable<T>{
	Object str[]=new Object[1];
	int N;
	
	public boolean isEmpty() {
		return str==null;
	}
	
	public void push(T item) {
		/*Doubling resizing reduces cost of insertion from N2 to N 
		because each time array increases by double by the time array
		resizes to double we are inserting elements in the array meanwhile*/  
		if(N==str.length) resize(2*str.length);
		str[N++]=item;
	}
	
	private void resize(int size) {//Dynamically resizing array
		T[] copy =(T[])new Object[size];
		for(int i =0;i<N;i++)
			copy[i]=(T)str[i];
		str=copy;
	}

	public T pop() {
		
		/*Similar to push we can also resize the array by half 
		 *when popping but this introduces a problem called Thrashing
		 *Thrashing== This when we do push and pop operation alternatively
		 *.Thus doubling and halving the array.This leads to Quadratic time complexity.
		 *Solution: We resize array when it is 25% full */  
		
		T item = (T)str[--N];
		str[N]=null;//Loitering or garbage collection
		if(N==str.length/4) resize(str.length/2);
		return item;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayStackIterator();
	}
	private class ArrayStackIterator<T> implements Iterator{

		
		
		@Override
		public boolean hasNext() {
			return N!=0;
		}

		@Override
		public T next() {
			return (T) str[--N];
		}
		
	}
	
	
}
