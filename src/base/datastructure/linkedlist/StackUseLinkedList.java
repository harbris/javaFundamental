package base.datastructure.linkedlist;

public class StackUseLinkedList {
    
	private static ListElement<String> head = null;
	
	public static void main(String[] args) {
		StackUseLinkedList sLinkedList = new StackUseLinkedList();
		ListElement<String> elem1 = new ListElement<String>("1");
		ListElement<String> elem2 = new ListElement<String>("2");
		ListElement<String> elem3 = new ListElement<String>("3");
		ListElement<String> elem4 = new ListElement<String>("4");
		System.out.println("=====push=====");
		sLinkedList.push(null,elem1);
		sLinkedList.push(elem1,elem2);
		sLinkedList.push(elem2,elem3);
		sLinkedList.printNode(head);
		System.out.println("=====pop=====");
		sLinkedList.pop(head);
		sLinkedList.printNode(head);
	}
	
	public int ListLength(ListElement<String> headNode){
    	int length = 0;
    	ListElement<String> currentNode = headNode;
    	while(currentNode != null){
    		length++;
    		currentNode = currentNode.getNext();
    	}
    	return length;
	}
	
	public void printNode(ListElement<String> headNode){
		ListElement<String> currentNode = headNode;
    	while(currentNode != null){
    		System.out.println(currentNode.getValue());
    		currentNode = currentNode.getNext();
    	}
	}
	
	public boolean push(ListElement<String> headNode, ListElement<String> nodeToInsert){
		nodeToInsert.setNext(headNode);
		head = nodeToInsert;
		return true;
	}
	
	public void pop(ListElement<String> headNode){
		head = headNode.getNext();
		headNode.setNext(null);
	}
	
}