package com.designPattern.functionMode;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.sqrt;

public class PrimeAlpha {
	private int number;

	public PrimeAlpha(int number) {
		this.number = number;
	}

	public boolean isPrime() {
		Set<Integer> primeSet = new HashSet<Integer>() {
			{
				add(1);
				add(number);
			}
		};
		return number > 1 && factors().equals(primeSet);
	}

	public boolean isFactor(int potential_factor) {
		return number % potential_factor == 0;
	}

	public Set<Integer> factors() {
		HashSet<Integer> factors = new HashSet<Integer>();
		for (int i = 1; i <= sqrt(number); i++)
			if (isFactor(i)) {
				factors.add(i);
				factors.add(number / i);
			}
		return factors;
	}
}