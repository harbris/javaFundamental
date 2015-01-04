package com.interview;

public class TreeElement<T> {
	private T data;
	private TreeElement<T> left;
	private TreeElement<T> right;
	
	public TreeElement(T value){data = value;}
	
	public TreeElement<T> getLeft(){return left;}
	public TreeElement<T> getRight(){return right;}
	public T getValue(){return data;}
	
	public void setLeft(TreeElement<T> elem){left = elem;}
	public void setRight(TreeElement<T> elem){right = elem;}
	public void setValue(T value){data = value;}
	
	public void printValue(){System.out.println(data);}
}
