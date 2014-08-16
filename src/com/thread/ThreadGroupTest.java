package com.thread;

public class ThreadGroupTest { 

        public static void main(String args[]) { 
                // main �����忡 ���� ������ ��� 
                System.out.println("ThreadGroupTest: " + Thread.currentThread()); 
                 
                // main ������׷��� ���� �׷��� ���� 
                ThreadGroup tGroup1 = new ThreadGroup(Thread.currentThread().getThreadGroup(), "ThreadGroup1"); 
                // main ������׷��� ���� �׷��� ���� 
                ThreadGroup tGroup2 = new ThreadGroup("ThreadGroup2"); 
                // tGroup1 ������׷��� ���� �׷��� ���� 
ThreadGroup tGroup3 = new ThreadGroup(tGroup1, "ThreadGroup3"); 

                Thread t1 = new Thread(tGroup1, "Thread-1"); 
                Thread t2 = new Thread(tGroup2, "Thread-2"); 
                Thread t3 = new Thread(tGroup3, "Thread-3"); 

                System.out.println("  t1: " + t1); 
                System.out.println("  t2: " + t2); 
                System.out.println("  t3: " + t3); 
                System.out.println( 
                        "main ������׷�: " 
                                + Thread.currentThread().getThreadGroup() 
                                + ", Ȱ������ ������ ����:" 
                                + Thread.currentThread().getThreadGroup().activeCount() 
                                + ", Ȱ������ ������׷� ����:" 
                                + Thread.currentThread().getThreadGroup().activeGroupCount()); 

                // main ������׷��� ����Ʈ�� ���. 
                Thread.currentThread().getThreadGroup().list(); 
        } 
} 
