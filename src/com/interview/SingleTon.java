package com.interview;

public class SingleTon{
	
	//ver1.기본적인 싱글턴 방식
	/*private static final SingleTon instance = new SingleTon();
	
	private SingleTon(){}
	
	public static SingleTon getInstance(){return instance;}
	
	public void log(String msg){
		System.out.println(System.currentTimeMillis()+": "+msg);
	}*/
	
	//ver2.지연 초기화 싱글턴 방식
	/*private static SingleTon instance = null;
	
	private SingleTon(){}
	
	public static SingleTon getInstance(){
		if(instance == null){
			instance = new SingleTon();
		}
		
		return instance;
	}
	
	public void log(String msg){
		System.out.println(System.currentTimeMillis()+": "+msg);
	}*/
	
	//ver3.지연 초기화 싱글턴 방식 스레드에 안전한
	//synchronized 키워드때문에 성능이 나빠진다
	/*private static SingleTon instance = null;
	
	private SingleTon(){}
	
	public synchronized static SingleTon getInstance(){
		if(instance == null){
			instance = new SingleTon();
		}
		
		return instance;
	}
	
	public void log(String msg){
		System.out.println(System.currentTimeMillis()+": "+msg);
	}*/
	
	//ver4.내부 클래스 지연 초기화 싱글턴 방식 
	//성능에도 영향이 없고 스레드에도 안전하다
	private static class SingleTonHolder{
		public static final SingleTon instance = new SingleTon();
	}
	
	public static SingleTon getInstance(){
		return SingleTonHolder.instance;
	}
}
