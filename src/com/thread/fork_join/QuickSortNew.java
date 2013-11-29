package com.thread.fork_join;

import java.util.Random;

public class QuickSortNew {
	long[] array;
	public QuickSortNew(long[] array){
		this.array = array;
	}
	public static long[] initArray(int SIZE){
		Random rnd = new Random();  
	    long[] array = new long[SIZE];  
	    for (int i = 0; i < SIZE; i++) {  
	        array[i] = rnd.nextInt();  
	    } 
	    return array;
	}
	public void compute(){
		quicksort(array,0,array.length-1);
	}
	private void quicksort(long[] array, int start, int end) {
		if(start<end){
			int i = start,j = end;
			long x = array[start];
			while(i<j){
				while(array[j]>=x && i<j){
					j--;
				}
				if(i<j){
					array[i]=array[j];
					i++;
				}
				while(array[i]<x && i<j){
					i++;
				}
				if(i<j){
					array[j] = array[i];
					j--;
				}
			}
			array[i] = x;
			quicksort(array,start,i-1);
			quicksort(array,i+1,end);
		}
	}
	public static void main(String[] a){
		
		QuickSortNew s = new QuickSortNew(QuickSortNew.initArray(1000));
		s.compute();
		s.print();
	}
	
	public void print() {
		
		for(int i = 1;i<array.length;i++){
			if(array[i]<array[i-1]){
				System.out.println("........");
				System.exit(0);
			}
		}
		for(int i = 1;i<=array.length;i++){
			System.out.print(array[i-1]+"\t");
			if(i%10==0){
				System.out.println();
			}
		}
	}
}
