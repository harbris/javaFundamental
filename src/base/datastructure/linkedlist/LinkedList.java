package base.datastructure.linkedlist;

public class LinkedList {
	
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
    	while(i < position ){
    		previousNode = previousNode.getNext(); 
    		i++;
    	}
    	if(position == 3){
    		nodeToInsert.setNext(elem2);
    	}else{
    		nodeToInsert.setNext(previousNode.getNext());
    	}
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
		
	public ListElement findMtoLastElement(ListElement<String> headNode, int m){
		ListElement<String> currentNode = headNode;
		
		for(int i=0 ; i < m ; i++){
			currentNode = currentNode.getNext();
		}
		
		ListElement<String> behindNode = headNode;
		while(currentNode.getNext() != null){
			currentNode = currentNode.getNext();
			behindNode = behindNode.getNext();
		}
    	
    	return behindNode;
	}
	
	public boolean determineTermination(ListElement<String> headNode){
		boolean result = false;
		ListElement<String> slowNode = headNode;
		ListElement<String> fastNode = headNode.getNext();
		
		while(true){
			if(fastNode== null || fastNode.getNext() == null){
				return false;
			}else if(fastNode.getValue() == slowNode.getValue() || fastNode.getNext().getValue() == slowNode.getValue()){
				return true;
			}else{
				slowNode = slowNode.getNext();
				fastNode = fastNode.getNext().getNext();
			}
		}
	}
	
	static ListElement<String> elem2 = new ListElement<String>("2");
	public static void main(String[] args) {
		LinkedList sLinkedList = new LinkedList();
		ListElement<String> elem1 = new ListElement<String>("1");
		
		ListElement<String> elem3 = new ListElement<String>("3");
		ListElement<String> elem4 = new ListElement<String>("4");
		System.out.println("=======insert======");
	    ListElement<String> insertNode1 = sLinkedList.InsertInLinkedList(null, elem1, 0);
	    ListElement<String> insertNode2 = sLinkedList.InsertInLinkedList(elem1, elem2, 1);
	    ListElement<String> insertNode3 = sLinkedList.InsertInLinkedList(elem1, elem3, 2);
	   	ListElement<String> insertNode4 = sLinkedList.InsertInLinkedList(elem1, elem4, 3);
		//sLinkedList.printNode(elem1);
		/*System.out.println("=======find======"+sLinkedList.findMtoLastElement(insertNode4,2).getValue());*/
	   	System.out.println("=======boolean======"+sLinkedList.determineTermination(elem1));
		
	}
	
}
