package com.test.ref.cache;

import java.util.Hashtable;


public class Employee {
	private String id;// 雇员的标识号码
	private String name;// 雇员姓名
	private String origin;// 该雇员信息的来源

	public Employee(String id) {
		this.id = id;
		getDataFromlnfoCenter();
	}

	private void getDataFromlnfoCenter() {
	}

	public String getID() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
}