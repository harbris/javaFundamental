package com.interview;

public class ListElement<T> {
	private T data;
	private ListElement<T> next;
	
	public ListElement(T value){data = value;}
	public ListElement<T> getNext(){return next;}
	public T getValue(){return data;}
	public void setNext(ListElement<T> elem){next = elem;}
	public void setValue(T value){data = value;}
}
