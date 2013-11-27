package com.thread.timer;

import java.util.Timer;

public class Test {  
	public static void main(String[] args){  
	   Timer timer = new Timer();  
	   timer.schedule(new TimerTaskTest(), 1000, 2000);  
	}  
	}  
