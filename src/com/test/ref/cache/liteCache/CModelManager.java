package com.test.ref.cache.liteCache;

import java.lang.ref.ReferenceQueue;


public class CModelManager<T> {
	private CacheRef<T> cacheRef ;
	public void CModelManager(T cache,ReferenceQueue<T> q){
		cacheRef = new  CacheRef(cache, q);
	}
}
