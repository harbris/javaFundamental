package com.thread;

// Runnable �������̽��� ���� 
public class RunnableThread implements Runnable { 
      // run() �� �������̵��Ͽ� ������.  
public void run() { 
                System.out.println("Runnable �������̽��� ����"); 
        } 
} 

public class RunnableThreadTest { 
        public static void main(String[] args) { 
                // Thread �����ڿ� RunnableThread �ν��Ͻ��� �Ķ���ͷ� ����. 
                Thread t = new Thread(new RunnableThread()); 
                t.start(); 
        } 
} 
