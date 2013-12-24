package com.test.ref.cache.liteCache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;

class CacheRef<T> extends SoftReference<T>{
	private String _key = "";
	public CacheRef(T cache,ReferenceQueue<T> q,String key) {
		super(cache,q);
		this._key = formKey(cache,key);
	}
	private String formKey(T cache,String key) {
		String method_name = "get"+key.substring(0,1).toUpperCase()+key.substring(1);
		String s = null;
		Method m = null;
		Object obj = null;
		try {
			m = cache.getClass().getMethod(method_name);
			obj = m.invoke(cache);
			if(obj instanceof Number || obj instanceof String){
				s =  obj+"";
				return s;
			}
			throw new Exception("key type must be a number or string");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			method_name = null;
			s = null;
			m = null;
			obj = null;
		}
		return s;
	}
	public String getKey(){
		return _key;
	}
}