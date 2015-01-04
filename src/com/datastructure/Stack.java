package com.datastructure;

public class Stack {
	private int top;
	private int capacity;
	public int[] array;
	
	public Stack(){
		capacity = 1;
		array = new int[capacity];
		top=-1;
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isStackFull(){
		return (top == (capacity-1));
	}
	
	public void push(int data){
		if(isStackFull()) System.out.println("Stack Overflow");
		else array[++top] = data;
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack Overflow");
			return 0;
		}
		else return (array[top--]);
	}
	
	public void deleteStack(){
		top= -1;
	}
	
	public static void main(String[] args) {
		
		Stack st = new Stack();
		st.push(1);
		//st.push(2);
		System.out.println(st.array.length);
	}
	
}
