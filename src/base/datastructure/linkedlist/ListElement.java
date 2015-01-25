package base.datastructure.linkedlist;

public class ListElement<T> {
	private T data;
	private ListElement<T> next;
	private ListElement<T> prev;
	private ListElement<T> child;
	
	public ListElement(T value){data = value;}
	
	public void setValue(T value){
		data = value;
	}
	public T getValue(){
		return data;
	}
	
	public void setNext(ListElement<T> elem){
		next = elem;
	}
	public ListElement<T> getNext(){
		return next;
	}

	public ListElement<T> getPrev() {
		return prev;
	}
	public void setPrev(ListElement<T> prev) {
		this.prev = prev;
	}

	public ListElement<T> getChild() {
		return child;
	}
	public void setChild(ListElement<T> child) {
		this.child = child;
	}
	
	
}
