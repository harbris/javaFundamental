package base.datastructure.tree;

import java.util.Stack;


public class BineryTree {
	public static void main(String[] args) {
		/*TreeElement<String> elemA = new TreeElement<String>("A");
		TreeElement<String> elemB = new TreeElement<String>("B");
		TreeElement<String> elemC = new TreeElement<String>("C");
		TreeElement<String> elemD = new TreeElement<String>("D");
		TreeElement<String> elemE = new TreeElement<String>("E");
		TreeElement<String> elemF = new TreeElement<String>("F");
		TreeElement<String> elemG = new TreeElement<String>("G");
		TreeElement<String> elemH = new TreeElement<String>("H");
		elemA.setLeft(elemB);
		elemA.setRight(elemC);
		elemC.setLeft(elemD);
		elemC.setRight(elemE);
		elemD.setLeft(elemF);
		elemD.setRight(elemG);
		elemE.setRight(elemH);
		preOrderTreversal(elemA);
		preOrderTreversalNotRecursive(elemA);*/
		TreeElement<Integer> elem20 = new TreeElement<Integer>(20);
		TreeElement<Integer> elem8 = new TreeElement<Integer>(8);
		TreeElement<Integer> elem22 = new TreeElement<Integer>(22);
		TreeElement<Integer> elem4 = new TreeElement<Integer>(4);
		TreeElement<Integer> elem12 = new TreeElement<Integer>(12);
		TreeElement<Integer> elem10 = new TreeElement<Integer>(10);
		TreeElement<Integer> elem14 = new TreeElement<Integer>(14);
		
		elem20.setRight(elem22);
		elem20.setLeft(elem8);
		elem8.setLeft(elem4);
		elem8.setRight(elem12);
		elem12.setLeft(elem10);
		elem12.setRight(elem14);
		
		System.out.println(findLowestCommonAncestor(elem20,elem4,elem14).getValue());
	}
	
	public static int treeHeight(TreeElement<String> n){
		if(n == null) return 0;
		return 1 + Math.max(treeHeight(n.getLeft()), treeHeight(n.getRight()));
	}
	
	public static void preOrderTreversal(TreeElement<String> n){
		if(n == null) return;
		n.printValue();
		preOrderTreversal(n.getLeft());
		preOrderTreversal(n.getRight());
	}
	
	public static void preOrderTreversalNotRecursive(TreeElement<String> n){
		if(n == null) return;
		Stack stack = new Stack();
		stack.push(n);
		while(stack.size() > 0 ){
			TreeElement<String> curr = (TreeElement<String>) stack.pop();
			curr.printValue();
			TreeElement<String> child = curr.getRight();
			if(child != null) stack.push(child);
			child = curr.getLeft();
			if(child != null) stack.push(child);
		}
	}
	
	public static void inOrderTreversal(TreeElement<String> n){
		if(n == null) return;
		inOrderTreversal(n.getLeft());
		n.printValue();
		inOrderTreversal(n.getRight());
	}
	
	public static void postOrderTreversal(TreeElement<String> n){
		if(n == null) return;
		inOrderTreversal(n.getLeft());
		inOrderTreversal(n.getRight());
		n.printValue();
	}
	
	public static TreeElement<Integer> findLowestCommonAncestor(TreeElement<Integer> root, TreeElement<Integer> n1,TreeElement<Integer> n2){
		while(root !=null){
			int value = root.getValue();
			
			if(value > n1.getValue() &&  value > n2.getValue()){
				root = root.getLeft();
			}else if(value < n1.getValue() &&  value < n2.getValue()){
				root = root.getRight();
			}else{
				return root;
			}
		}
		
		return null;
	}
	
	public static int traverse(TreeElement<Integer> node, int count, TreeElement<Integer>[] arr){
		if(node == null)
			return count;
		
		if(arr != null)
			arr[count] = node;
		
		count++;
		
		count = traverse(node.getLeft(),count,arr);
		count = traverse(node.getRight(),count,arr);
		return count;
	}
	
	
}
