package com.test.ref.cache.liteCache;

import java.lang.ref.ReferenceQueue;
import java.util.Hashtable;

import com.test.ref.Page;

public class LiteCache<T> {
	private Hashtable<String, CacheRef<T>> refs;// 用于Chche内容的存储
	private ReferenceQueue<T> queue;// 垃圾Reference的队列
	public LiteCache(){
		this.refs = new Hashtable<String,CacheRef<T>>();
		this.queue = new ReferenceQueue<T>();
	}
	public int size(){
		return refs.size();
	}
	public void put(T t){
		cleanCache();
		CacheRef<T> cacheRef = new CacheRef<T>(t,queue);
		refs.put(cacheRef.getKey(), cacheRef);
	}
	@SuppressWarnings("unchecked")
	private void cleanCache(){
		System.out.println(refs.size());
		CacheRef<T> obj = null;
		System.out.println(queue.poll());
		while ((obj =  (CacheRef<T>) queue.poll()) != null) {
			System.out.println(obj.get()+".........."+obj.getKey());
			obj.get();
			refs.remove(obj.getKey());
		}
	}
	
	public void clearCache() {
		cleanCache();
		refs.clear();
		System.gc();
		System.runFinalization();
	}
	public T get(String key){
		if(refs.get(key)==null){
			return null;
		}
		return refs.get(key).get();
	}
	public static void main(String[] args ){
		
		LiteCache<Page> c = new LiteCache<Page>();
		try {
			for(int i = 0 ;i<1000000000;i++){
				Page p = new Page();
				p.add(i+"ss");
				c.put(p);
				c.get("p:["+i+"ss]");
				
				
			}
		} catch (RuntimeException e) {
			System.out.println(c.size());
			e.printStackTrace();
		}
		Page p = c.get("0:[314123ss]");
		System.out.println(p);
	}
	
}
