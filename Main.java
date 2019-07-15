package com.suddha;

public class Main {
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		for(Integer i:stack)
			System.out.println(i);
		
	}

}
