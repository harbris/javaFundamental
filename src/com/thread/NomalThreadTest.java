package com.thread;

public class NomalThreadTest { 
         
        public static void main(String[] args) { 
                // ������ ���� 
                Thread t = new Thread() { 
                        public void run() { 
                                try { 
                                        // 5�ʰ� ���� 
                                        Thread.sleep(5000); 
                                        // ������ ���� �޼��� 
                                        System.out.println("MyThread ����"); 
                                } catch (Exception e) { 
                                        // ����.. 
                                } 
                        } 
                } 
                // ������ ���� 
                t.start(); 
                 
                // main �޼ҵ� ���� �޼��� 
                System.out.println("main() ����"); 
        } 
} 
