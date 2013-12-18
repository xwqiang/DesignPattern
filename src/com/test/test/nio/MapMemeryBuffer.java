package com.test.test.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MapMemeryBuffer {  
	  
    private static String fileName = "e:/iotest/iotest.zip";  
  
    private static String fileName1 = "e:/iotest/testmaped.zip";  
  
    public static void main(String[] args) throws Exception {  
        long start = System.currentTimeMillis();
    	mapBufferWriteFile();  
    	long end = System.currentTimeMillis();
    	System.out.println(end- start);//8789
    }  
  
    public static long length;  
  
    public static ByteBuffer mapBufferReadFile() {  
        try {  
            RandomAccessFile fis = new RandomAccessFile(fileName, "r");  
            FileChannel fc = fis.getChannel();  
            length = fc.size();  
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0,  
                length);  
            return mbb.get(new byte[(int) fc.size()]);  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return null;  
  
    }  
  
    public static void mapBufferWriteFile() {  
        try {  
            long start = System.currentTimeMillis();  
            // FileOutputStream fos = new FileOutputStream(fileName1);  
            RandomAccessFile fos = new RandomAccessFile(fileName1, "rw");  
            FileChannel fc = fos.getChannel();  
            ByteBuffer bb = mapBufferReadFile();  
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0,  
                length);  
            for (int i = 0; i < length; i++) {  
                mbb.put(i, bb.get(i));  
            }  
            mbb.flip();  
            System.out.println(System.currentTimeMillis() - start);  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  
