package com.test.ref.cache.liteCache;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileWriterUtil<T> {
	private String file_path ;
	private String file_name;
	private String separator ;
	private FileOutputStream fos;
	private ObjectOutputStream oos;
	private String file ;
	public FileWriterUtil(){
		try {
			file_path = System.getProperty("user.dir");
			file_name = "over_flow_data";
			separator = System.getProperty("file.separator");
			file =file_path+separator+file_name+".dat";
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void writeToFile(List<T> overflow_list) throws IOException  {
		if(fos==null){
			fos = new FileOutputStream(file);
		}
		for(T t : overflow_list){
			oos.writeObject(t);
		}
		oos.flush();
	}
	public List<T> readFromFile() throws Exception{
		List<T> list = null;
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = null;
		while((obj=ois.readObject())!=null){
			T t = (T) obj;
			list.add(t);
		}
		return list;
	}
	@Override
	public void finalize(){
		try {
			if(fos!=null){
				fos.close();
			}
			if(oos!=null){
				oos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] a){
		try {
			FileWriterUtil<UserInfo> f = new FileWriterUtil<UserInfo>();
			List<UserInfo> user = f.readFromFile();
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
