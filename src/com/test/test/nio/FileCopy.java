package com.test.test.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {
	static File f = new File("e:/iotest/iotest.zip");
	public static void niocopy(){
		try {
			FileInputStream fis = new FileInputStream(f);
			FileChannel fc = fis.getChannel();
			ByteBuffer bb = ByteBuffer.allocate((int)fc.size());
			fc.read(bb);
			bb.flip();
			
			FileOutputStream fos = new FileOutputStream("e:/iotest/iotestnio.zip");
			FileChannel foc = fos.getChannel();
			foc.write(bb);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void copy(){
		try {
			FileInputStream fis = new FileInputStream(f);
			int size = (int) f.length();
			byte[] b = new byte[size];
			fis.read(b);
			
			FileOutputStream fos = new FileOutputStream("e:/iotest/iotestcopy.zip");
			fos.write(b);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
//		System.out.print(Integer.MAX_VALUE/1024/1024/1024);//g
		
		long start = System.currentTimeMillis();
//		niocopy();//4045
		copy();//8514

		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
