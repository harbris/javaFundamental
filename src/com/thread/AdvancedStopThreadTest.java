package com.thread;


public class AdvancedStopThread implements Runnable { 

        public void run() { 
                try { 
                        // isInterrupted() �޼ҵ带 while �� �������� ���. ���� �� �����忡 interrupt() �޼ҵ带 ȣ���ϸ� 
//isInterrupted() �޼ҵ�� true �� �����ؼ� while ���� ���������� �ȴ�. 
                        while (!Thread.currentThread().isInterrupted()) { 
                                System.out.println("Thread is alive.."); 
                                // 0.5�ʰ� ����. 
                                Thread.sleep(500); 
                        } 
                } catch (InterruptedException e) { 
                        // �����ߴ� �����̹Ƿ� ����.. 
                } finally { 
                        // ������ �ؾ��� �۾��� �ִٸ� �̰����� ����. 
                        System.out.println("Thread is dead.."); 
                } 
        } 
} 

public class AdvancedStopThreadTest { 
        public static void main(String[] args) { 
                System.out.println("# Start AdvancedStopThreadTest.java"); 
                AdvancedStopThreadTest astt = new AdvancedStopThreadTest(); 
                astt.process(); 
        } 

        public void process() { 
                // AdvancedStopThread �ν��Ͻ��� ������ �� �� ���ڸ� �Ķ���ͷ� �޴� 
                // ������ �ν��Ͻ��� ������ �Ŀ� ��߽�Ŵ. 
                AdvancedStopThread ast = new AdvancedStopThread(); 
                Thread thread = new Thread(ast); 
                thread.start(); 

                try { 
                        // 1�ʰ� ����. 
                        Thread.sleep(1000); 
                } catch (InterruptedException e) { 
                        e.printStackTrace(); 
                } 
                 
                // AdvancedStopThread �� ������Ŵ. 
                thread.interrupt(); 
        } 
} 
