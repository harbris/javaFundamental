package com.thread;

import java.util.Random;

public class ThreadLocalTest {
	
	// ī���� ���� ����.
	static volatile int counter = 0;
	// ���� Ŭ���� ����.
	static Random random = new Random();

	// ThreadLocal �� ����� ThreadLocalObject Ŭ���� ����.
	private static class ThreadLocalObject extends ThreadLocal {
		Random random = new Random();
		// �ʱⰪ���� 0~999 ������ �������� ����.
		// initialValue() �޼ҵ��� �����ڰ� protected �ӿ� ����.
		// return ���� Object �ӿ� ����.
		protected Object initialValue() {
			return new Integer(random.nextInt(1000));
		}
	}
	// ThreadLocal �� ���� ����.
	static ThreadLocal threadLocal = new ThreadLocalObject();

	// �� �������� value ��� �޼ҵ�.
	private static void displayValues() {
		System.out.println("Thread Name:"
				+ Thread.currentThread().getName()
				+ ", initialValue:"
				+ threadLocal.get()
				+ ", counter:"
				+ counter);
	}

	public static void main(String args[]) {
		// main ������ value ���.
		displayValues();
		
		Runnable runner = new Runnable() {
			public void run() {
				synchronized (ThreadLocalTest.class) {
					// ī���͸� 1 ������Ŵ.
					counter++;
				}
				// value ���.
				displayValues();
				try {
					// ����������� �ʱⰪ��ŭ ����.
					Thread.sleep(((Integer) threadLocal.get()).intValue());
					// value ���.
					displayValues();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		// ������ 3���� �����ؼ� �� ������ value �� ���.
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(runner);
			t.start();
		}
	}
}
