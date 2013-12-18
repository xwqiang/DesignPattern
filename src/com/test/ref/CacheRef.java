package com.test.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class CacheRef<T extends IKeyValue> extends SoftReference<T>{
	private T cache;
	private String _key = "";
	public CacheRef(T cache,ReferenceQueue<T> q) {
		super(cache,q);
		this.cache = cache;
	}
//	public String getKey(){
//		_key = cache.toString();
//		return _key;
//	}
//	public T get(){
//		return cache;
//	}
}