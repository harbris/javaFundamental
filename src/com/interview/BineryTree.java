package com.interview;


public class BineryTree {
	public static void main(String[] args) {
		TreeElement<String> elemA = new TreeElement<String>("A");
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
		inOrderTreversal(elemA);
		//System.out.println(treeHeight(elemC));
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
}
