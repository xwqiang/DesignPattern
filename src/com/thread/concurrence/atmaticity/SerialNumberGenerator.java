package com.thread.concurrence.atmaticity;

public class SerialNumberGenerator {
	public static int serialNumber = 0;
	public static int num = 0;
	public int nextSerialNumber(){
		nexrnum();
//		Thread.yield();
		return serialNumber++;
	}
	public synchronized int nexrnum(){
		return num++;
	}
	public int getnum(){
		return num;
	}
}
