package com.proxy;

public class BarImpl implements Bar {
	public void hello(int i, String s) {
		System.out.println("   in net.javajigi.oss.proxy.Bar.hello");
	}

	public void goodbye(String str, int i) {
		System.out.println("   in net.javajigi.oss.proxy.Bar.goodbye");
	}

}