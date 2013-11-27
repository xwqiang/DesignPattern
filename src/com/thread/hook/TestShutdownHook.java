package com.thread.hook;

public class TestShutdownHook {
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// �����߳�1
		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("thread1...");
			}
		};
		// �����߳�2
		Thread thread2 = new Thread() {
			public void run() {
				System.out.println("thread2...");
			}
		};
		// ����ر��߳�
		Thread shutdownThread = new Thread() {
			public void run() {
				System.out.println("shutdownThread...");
			}
		};
		// jvm�رյ�ʱ����ִ�и��̹߳���
		Runtime.getRuntime().addShutdownHook(shutdownThread);
		thread1.start();
		thread2.start();
		Thread.sleep(1000);
	}
}