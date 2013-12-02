package com.mathatic.recursion;

public class InteratorTest {

	long Recursion (int n) {
	    if (n == 1) {
	        return 1;
	    } else {
	        return n*Recursion(n-1);
	    }
	}
	long Iteration(int n){
		long sum = 1;
		for(int i = 1 ;i <=n ;i++){
			sum*=i;
		}
		return sum;
	}
	
	public static int getBit(int num, int i){
		int result = num & (1<<i);
		if(result == 0){
			return 0;
		}else{
			return result;
		}
	}
	public static void main(String[] args) {
		InteratorTest i = new InteratorTest();
		long ii = i.Recursion(23);
		long jj = i.Iteration(23);
		System.out.println(ii);
		System.out.println(jj);
		int b = getBit(110,1);
		System.out.println(b);

	}

}
