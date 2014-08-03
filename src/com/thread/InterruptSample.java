package com.thread;

public class InterruptSample {
	
	public static void main(String[] args) throws Exception{
		InfinitThread infinit = new InfinitThread();
		infinit.start();
		Thread.sleep(2000);
		System.out.println();
		infinit.interrupt();
		System.out.println();
	}

}


