package com.thread;

public class StopThread implements Runnable { 
        // ���ǹ� ���������� ���� ����� �÷��� ����. 
        private boolean stopped = false; 

        public void run() { 
                // stopped �÷��׸� while �� �������� ���. 
                while (!stopped) { 
                        System.out.println("Thread is alive.."); 
                        try { 
                                // 0.5�ʰ� ����. 
                                // �̰����� sleep �޼ҵ带 ȣ���ϴ� ������ while ���� �ݺ����� ����� �������� �����ϸ� CPU�� ���� �δ��� �ֱ� �����̴�. 
                                // �ñ��� ���ڵ��� sleep �޼ҵ� �κ��� ���� �ٽ� ������ �� �Ŀ� CPU ������ �����غ��� �ٶ���. Ȯ���� ���̰� �� ���̴�. 
                                Thread.sleep(500); 
                        } catch (InterruptedException e) { 
                                e.printStackTrace(); 
                        } 
                } 
                System.out.println("Thread is dead.."); 
        } 

        // �� �޼ҵ� ȣ��� StopThread �� ����. 
        public void stop() { 
                stopped = true; 
        } 
} 

public class StopThreadTest { 
        public static void main(String[] args) { 
                System.out.println("# Start StopThreadTest.java"); 
                StopThreadTest stt = new StopThreadTest(); 
                stt.process(); 
        } 

        public void process() { 
                // StopThread �ν��Ͻ��� ������ �� �� ���ڸ� �Ķ���ͷ� �޴� 
                // ������ �ν��Ͻ��� ������ �Ŀ� ��߽�Ŵ. 
                StopThread st = new StopThread(); 
                Thread thread = new Thread(st); 
                thread.start(); 

                try { 
                        // 1�ʰ� ����. 
                        Thread.sleep(1000); 
                } catch (InterruptedException e) { 
                        e.printStackTrace(); 
                } 
                 
                // StopThread �� ������Ŵ. 
                st.stop(); 
        } 
} 
