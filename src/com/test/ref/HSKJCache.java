package com.test.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Hashtable;

public class HSKJCache<T extends IKeyValue> {
	private Hashtable<String, CacheRef<T>> refs;// 用于Chche内容的存储
	private ReferenceQueue<T> queue;// 垃圾Reference的队列
	public HSKJCache(){
		this.refs = new Hashtable<String,CacheRef<T>>();
		this.queue = new ReferenceQueue<T>();
	}
	public int size(){
		return refs.size();
	}
	public void put(T t){
		clean();
		CacheRef<T> cacheRef = new CacheRef<T>(t,queue);
		refs.put(t.getKey(), cacheRef);
	}
	private void clean(){
		CacheRef<T> obj = null;
		while ((obj = (CacheRef<T>) queue.poll()) != null) {
			
			System.out.println(obj.get()+"..........");
			obj.get();
			refs.remove(obj.get().getKey());
		}
	}
	public T get(String key){
		if(refs.get(key)==null){
			return null;
		}
		return refs.get(key).get();
	}
	public static void main(String[] a ){
		/*Map<String,Page> map = new HashMap<String,Page>();
		for(int i = 0 ;i<1000000000;i++){
			map.put(i+"dd",new Page(){{add("dd");}});
		}*/
		
		HSKJCache<Page> c = new HSKJCache<Page>();
		try {
			for(int i = 0 ;i<1000000000;i++){
				Page p = new Page();
				p.add(i+"ss");
				c.put(p);
			}
		} catch (RuntimeException e) {
			System.out.println(c.size());
			e.printStackTrace();
		}
		Page p = c.get("0:[314123ss]");
		System.out.println(p);
	}
	
}
