package com.designPattern;

public class IntegerHolder {

	public Integer value;

	public IntegerHolder(Integer i)
	{
		value = i;
	}

	public static void ChangeInteger(Integer i)
	{
		i = new Integer(10);
	}

	public static void ChangeInteger(IntegerHolder i)
	{
		i.value = new Integer(10);
	}
	public static void main(String args[]) {
		Integer i = new Integer(5);
		ChangeInteger(i);
		System.out.println(i.intValue());
		IntegerHolder ih = new IntegerHolder(i);
		ChangeInteger(ih);
		i = ih.value;
		System.out.println(i.intValue());
	}
}
