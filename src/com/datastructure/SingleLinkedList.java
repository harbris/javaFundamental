package com.datastructure;

public class SingleLinkedList {
	
	public static void main(String[] args) {
		
		ListNode currentNode = new ListNode(1);
		ListNode addNode = new ListNode(2);
		ListNode insertNode = InsertInLinkedList(currentNode,addNode,2);
		ListNode addNode1 = new ListNode(3);
		insertNode = InsertInLinkedList(currentNode,addNode1,3);
		System.out.println("=======insert======");
		printNode(insertNode);
		System.out.println("=======delete======");
		ListNode deleteNode = DeleteInLinkedList(insertNode, 2);
		printNode(deleteNode);
		
	}

    static int ListLength(ListNode headNode){
    	int length = 0;
    	ListNode currentNode = headNode;
    	while(currentNode != null){
    		length++;
    		currentNode = currentNode.getNext();
    	}
    	return length;
    }
    
    static void printNode(ListNode headNode){
    	ListNode currentNode = headNode;
    	while(currentNode != null){
    		System.out.println(currentNode.getData());
    		currentNode = currentNode.getNext();
    	}
    }
    
    static ListNode InsertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position){
    	if(headNode == null) return nodeToInsert;
    	int size = ListLength(headNode);
    	if(position > size+1 || position < 1){
    		System.out.println("Position of node to insert is invalid. The valid inputs ard 1 to " + (size+1));
    		return headNode;
    	}
    	
    	if(position == 1){ //첫 노드를 삽입한다
    		nodeToInsert.setNext(headNode);
    		return nodeToInsert;
    	}else{ //중간과 끝에 노드를 삽입한다
    		ListNode previousNode = headNode;
    		int count = 1;
    		while(count < position -1){
    			previousNode = previousNode.getNext();
    			count++;
    		}
    		ListNode currentNode = previousNode.getNext();
    		nodeToInsert.setNext(currentNode);
    		previousNode.setNext(nodeToInsert);
    	}
    	return headNode;
    
    }
    
    static ListNode DeleteInLinkedList(ListNode headNode, int position){
    	int size = ListLength(headNode);
    	if(position < 1 || position > size){ 
    		System.out.println("not exist node");
    		return headNode;
    	}
    	
    	if(position == 1){ //첫 노드를 삽입한다
    		return headNode.getNext();
    	}else{
    		ListNode previousNode = headNode;
    		int count = 1;
    		while(count < position -1){
    			previousNode = previousNode.getNext();
    			count++;
    		}
    		ListNode currentNode = previousNode.getNext();
    		previousNode.setNext(currentNode.getNext());
    		currentNode = null;
    	}
    	return headNode;
    }
}

class ListNode{
	private int data;
	private ListNode next;
	public ListNode(int data){
		this.data = data;
	}
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return data;
	}
	public void setNext(ListNode next){
		this.next = next;
	}
	public ListNode getNext(){
		return this.next;
	}
	
}