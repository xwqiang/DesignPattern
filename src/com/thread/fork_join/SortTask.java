package com.thread.fork_join;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
/**
 * 混合的快速排序 要求jdk7
 * @author 1207264
 *
 */
public class SortTask extends RecursiveAction {  
	private static final long serialVersionUID = 1L;
	final long[] array;  
    final int start;  
    final int end;  
    private int THRESHOLD = 10000; //For demo only  
  
    public SortTask(long[] array) {  
        this.array = array;  
        this.start = 0;  
        this.end = array.length - 1;  
    }  
  
    public SortTask(long[] array, int start, int end) {  
        this.array = array;  
        this.start = start;  
        this.end = end;  
    }  
  
    protected void compute() {  
        if (end - start < THRESHOLD)
            sequentiallySort(array, start, end);  
        else {  
            int pivot = partition(array, start, end);  
            new SortTask(array, start, pivot - 1).fork();  
            new SortTask(array, pivot + 1, end).fork();  
        }  
    }  
    public void compute(long[] array,int start,int end){
    	if (end - start < THRESHOLD)
            sequentiallySort(array, start, end);  
        else {  
            int pivot = partition(array, start, end);  
            compute(array,start,pivot-1);
            compute(array,pivot+1,end);
        }  
    }  
    private int partition(long[] array, int start, int end) {  
        long x = array[end];  
        int i = start - 1;  
        for (int j = start; j < end; j++) {  
            if (array[j] <= x) {  
                i++;  
                swap(array, i, j);  
            }  
        }  
        swap(array, i + 1, end);  
        return i + 1;  
    }  
  
    private void swap(long[] array, int i, int j) {  
        if (i != j) {  
            long temp = array[i];  
            array[i] = array[j];  
            array[j] = temp;  
        }  
    }  
  
    private void sequentiallySort(long[] array, int lo, int hi) {  
        Arrays.sort(array, lo, hi + 1);  
    }  
}  
