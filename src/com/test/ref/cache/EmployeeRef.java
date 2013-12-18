package com.test.ref.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class EmployeeRef extends SoftReference<Employee> {
	private String _key = "";

	public EmployeeRef(Employee em, ReferenceQueue<Employee> q) {
		super(em, q);
		_key = em.getID();
	}
}