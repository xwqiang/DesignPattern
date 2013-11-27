package com.thread.criticalSession;

public class Pair {
	private int x,y;
	public Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
	public Pair(){
		this(0,0);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void incrementX(){
		x++;
	}
	public void incrementY(){
		y++;
	}
	@Override
	public String toString(){
		return "x:"+x+",y:"+y;
	}
	@SuppressWarnings("serial")
	public class PariValueNotEqualException extends RuntimeException{
		public PariValueNotEqualException(){
			super("pair values not eauql: "+ Pair.this);
		}
	}
	public void checkStat(){
		if(x!=y){
			throw new PariValueNotEqualException();
		}
	}
}
