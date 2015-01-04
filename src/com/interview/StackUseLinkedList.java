package com.interview;

public class StackUseLinkedList {

	public static void main(String[] args) {
		StackUseLinkedList sLinkedList = new StackUseLinkedList();
		ListElement<String> elem1 = new ListElement<String>("1");
		ListElement<String> elem2 = new ListElement<String>("2");
		ListElement<String> elem3 = new ListElement<String>("3");
		ListElement<String> elem4 = new ListElement<String>("4");
		ListElement<String> insertNode1 = sLinkedList.InsertInLinkedList(null, elem1, 0);
		//ListElement<String> insertNode2 = sLinkedList.InsertInLinkedList(elem1, elem2, 1);
		System.out.println("=======push======");
		sLinkedList.push(elem1, elem2);
		sLinkedList.push(elem1, elem3);
		sLinkedList.push(elem1, elem4);
		//sLinkedList.printNode(elem1);
		sLinkedList.findMtoLastElement(elem1,4);
		/*sLinkedList.pop(elem1);
		sLinkedList.printNode(elem1);
		sLinkedList.pop(elem1);		
		sLinkedList.printNode(elem1);*/
		/*System.out.println("=======insert======");
		ListElement<String> insertNode3 = sLinkedList.InsertInLinkedList(elem1, elem3, 1);
		sLinkedList.printNode(elem1);
		System.out.println("=======delete======");
		sLinkedList.deleteInLinkedList(elem1,1);
		sLinkedList.printNode(elem1);*/
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
	
	public ListElement<String> InsertInLinkedList(ListElement<String> headNode, ListElement<String> nodeToInsert, int position){
		if(headNode == null) return nodeToInsert;
		int size = ListLength(headNode);
		
		if(position > size+1 || position < 1){
    		System.out.println("Position of node to insert is invalid. The valid inputs ard 1 to " + (size+1));
    		return headNode;
    	}
		
		ListElement<String> previousNode = headNode;
    	int i = 1;
    	while(i < position - 1){
    		previousNode = previousNode.getNext(); 
    		i++;
    	}
    	nodeToInsert.setNext(previousNode.getNext());
    	previousNode.setNext(nodeToInsert);
        	
		return headNode;
		
	}
	
	public void deleteInLinkedList(ListElement<String> headNode, int position){
		int size = ListLength(headNode);
    	if(position < 1 || position > size){ 
    		System.out.println("not exist node");
    	}
    	
    	ListElement<String> previousNode = headNode;
    	int i = 1;
    	while(i < position - 1){
    		previousNode = previousNode.getNext(); 
    		i++;
    	}
    	previousNode.setNext(previousNode.getNext().getNext());
	}
	
	
	public void push(ListElement<String> headNode, ListElement<String> nodeToInsert){
		int size = ListLength(headNode);
		
		ListElement<String> currentNode = headNode;
		ListElement<String> previousNode = headNode;
    	while(currentNode != null){
    		if(currentNode.getNext() !=null){
    			previousNode = currentNode.getNext();
    		}
    		currentNode = currentNode.getNext();
    	}
    	previousNode.setNext(nodeToInsert);
        	
	}
	
	public void pop(ListElement<String> headNode){
		int size = ListLength(headNode);
    	
		ListElement<String> currentNode = headNode;
		ListElement<String> previousNode = headNode;
    	while(currentNode != null){
    		if(currentNode.getNext() !=null){
    			previousNode = currentNode;
    		}
    		currentNode = currentNode.getNext();
    	}
    	System.out.println("pop==>"+previousNode.getNext().getValue());
    	previousNode.setNext(null);
	}
	
	public void findMtoLastElement(ListElement<String> headNode, int m){
		ListElement<String> currentNode = headNode;
		ListElement<String> behindNode = headNode;
		int length = 0;
		String value = "";
    	while(currentNode != null){
    		if(length == m || length > m){
    			behindNode = behindNode.getNext();
    		}
    		currentNode = currentNode.getNext();
    		length++;
    	}
    	System.out.println(behindNode.getValue());
	}
	

}