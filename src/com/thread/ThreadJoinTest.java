package com.thread;

public class ThreadJoinTest { 
         
        public static void main(String[] args) { 
                // ������ ���� 
                Thread t = new Thread() { 
                        public void run() { 
                                try { 
                                        // 2�ʰ� ���� 
                                        Thread.sleep(2000); 
                                        // ������ ���� �޼��� 
                                        System.out.println("MyThread ����"); 
                                        // 3�ʰ� ���� 
                                        Thread.sleep(3000); 
                                } catch (Exception e) { 
                                        // ����.. 
                                } 
                        } 
                } 
                // ������ ���� 
                t.start(); 
                try { 
                        // join() �޼ҵ� ����.. 
                        // t �����尡 ����ɶ����� main �����尡 ��ٸ�. 
                        // join() �޼ҵ尡 InterruptedException �� �߻���Ű�°Ϳ� ����. 
                        t.join(); 
                } catch (InterruptedException e) { 
                        e.printStackTrace(); 
                } 
                 
                // main �޼ҵ� ���� �޼��� 
                System.out.println("main() ����"); 
        } 
} 
