package com.thread;

// Thread Ŭ������ ���. 
public class ExtendThread extends Thread { 
        // run() �� �������̵��Ͽ� ������. 
        public void run() { 
                System.out.println("Thread Ŭ������ ���"); 
        } 
} 

public class ExtendThreadTest { 
        public static void main(String[] args) { 
                ExtendThread et = new ExtendThread(); 
                // start() �� �̿��Ͽ� �����带 ���� ��Ų��. 
                // ���� ExtendThread �� run() �� ����ǰ� run() �� ����Ǹ� �ٷ� ExtendThread �� �Ҹ�ȴ�. 
                et.start(); 
        } 
} 
