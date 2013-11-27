package com.thread.sync.syncObject;

public class SyncObject {
	public static void main(String[] a){
		final DualSynch ds = new DualSynch();
		new Thread(){
			public void run(){
				ds.f();
			}
		}.start();
		ds.g();
	}
}
