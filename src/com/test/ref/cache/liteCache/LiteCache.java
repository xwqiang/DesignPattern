package com.test.ref.cache.liteCache;

import java.lang.ref.ReferenceQueue;
import java.util.Hashtable;


public class LiteCache<T> {
	private Hashtable<String, CacheRef<T>> refs;// 用于Chche内容的存储
	private String key;
	private ReferenceQueue<T> queue;// 垃圾Reference的队列
	public LiteCache(){
		this.refs = new Hashtable<String,CacheRef<T>>();
		this.queue = new ReferenceQueue<T>();
	}
	public int size(){
		return refs.size();
	}
	
	public void setKey(String key){
		this.key = key;
	}
	public void put(T t) throws Exception{
		cleanCache();
		CacheRef<T> cacheRef = new CacheRef<T>(t,queue,key);
		refs.put(cacheRef.getKey(), cacheRef);
	}
	@SuppressWarnings("unchecked")
	private void cleanCache() throws Exception{
		CacheRef<T> obj = null;
 		while ((obj = (CacheRef<T>) queue.poll()) != null) {
			refs.remove(obj.getKey());
		}
	}
	public void clearCache() {
		try {
			cleanCache();
			refs.clear();
			System.gc();
			System.runFinalization();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public T get(String key){
		if(refs.get(key)==null){
			return null;
		}
		return refs.get(key).get();
	}
}
