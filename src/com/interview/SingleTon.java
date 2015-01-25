package com.interview;

public class SingleTon{
	
	//ver1.�⺻���� �̱��� ���
	/*private static final SingleTon instance = new SingleTon();
	
	private SingleTon(){}
	
	public static SingleTon getInstance(){return instance;}
	
	public void log(String msg){
		System.out.println(System.currentTimeMillis()+": "+msg);
	}*/
	
	//ver2.���� �ʱ�ȭ �̱��� ���
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
	
	//ver3.���� �ʱ�ȭ �̱��� ��� �����忡 ������
	//synchronized Ű���嶧���� ������ ��������
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
	
	//ver4.���� Ŭ���� ���� �ʱ�ȭ �̱��� ��� 
	//���ɿ��� ������ ���� �����忡�� �����ϴ�
	private static class SingleTonHolder{
		public static final SingleTon instance = new SingleTon();
	}
	
	public static SingleTon getInstance(){
		return SingleTonHolder.instance;
	}
}
