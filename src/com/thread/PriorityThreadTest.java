package com.thread;

class PriorityThread implements Runnable {

	public void run() {
		try { 
			// isInterrupted() �޼ҵ带 while �� �������� ���. ���� �� �����忡 interrupt() �޼ҵ带 ȣ���ϸ� 
			//isInterrupted() �޼ҵ�� true �� �����ؼ� while ���� ���������� �ȴ�. 
			while (!Thread.currentThread().isInterrupted()) { 
				// PriorityThread �� �켱������ ���.
				System.out.println("Priority : " + Thread.currentThread().getPriority()); 
				// 0.5�ʰ� ����. 
				Thread.sleep(500); 
			} 
		} catch (InterruptedException e) { 
			// �����ߴ� �����̹Ƿ� ����.. 
		}
	}
}

public class PriorityThreadTest {

	public static void main(String args[]) throws InterruptedException {
		System.out.println("Start Main..");
		System.out.println("Thread.MAX_PRIORITY : " + Thread.MAX_PRIORITY);
		System.out.println("Thread.MIN_PRIORITY : " + Thread.MIN_PRIORITY);
		System.out.println("Thread.NORM_PRIORITY : " + Thread.NORM_PRIORITY);

		// �����带 �����ϰ� ���� ��Ŵ.
		// �⺻������ Thread.NORM_PRIORITY, �� 5�� �켱���� ���� ���Ե�.
		Thread t = new Thread(new PriorityThread());
		t.start();
		Thread.sleep(500);
		
		// �켱������ Thread.MIN_PRIORITY, �� 1�� �ٲ�.
		t.setPriority(Thread.MIN_PRIORITY);
		Thread.sleep(500);
		
		// �켱������ 8�� �ٲ�.
		t.setPriority(8);
		Thread.sleep(500);
		
		// �켱������ Thread.MAX_PRIORITY, �� 10���� �ٲ�.
		t.setPriority(Thread.MAX_PRIORITY);
		Thread.sleep(500);
		
		// �����带 �����Ŵ.
		t.interrupt();

		System.out.println("End Main..");
	}
}
