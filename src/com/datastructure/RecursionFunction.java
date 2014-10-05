package com.datastructure;

public class RecursionFunction {
	public static void main(String[] args) {
		System.out.println(Print(4));
	}
	
	static int Fact(int n){
		if(n == 1) return 1;
		else if(n == 0) return 0;
		else{
			return n*Fact(n-1);
		}
	}
	
	static int Print(int n){
		if(n == 0) return 0;
		else{
			return Print(n-1);
		}
	}
}
