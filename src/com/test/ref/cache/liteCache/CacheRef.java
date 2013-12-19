package com.test.ref.cache.liteCache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class CacheRef<T> extends SoftReference<T>{
	private String _key = "";
	public CacheRef(T cache,ReferenceQueue<T> q) {
		super(cache,q);
		this._key = cache.toString();
	}
	public String getKey(){
		return _key;
	}
}