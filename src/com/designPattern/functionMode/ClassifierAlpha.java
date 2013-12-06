package com.designPattern.functionMode;
import static java.lang.Math.sqrt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ClassifierAlpha {
    private int number;

    public ClassifierAlpha(int number) {
        this.number = number;
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

    static public int sum(Set<Integer> factors) {
        Iterator it = factors.iterator();
        int sum = 0;
        while (it.hasNext())
            sum += (Integer) it.next();
        return sum;
    }

    public boolean isPerfect() {
        return sum(factors()) - number == number;
    }

    public boolean isAbundant() {
        return sum(factors()) - number > number;
    }

    public boolean isDeficient() {
        return sum(factors()) - number < number;
    }
    
    public static void main(String[] a){
    	ClassifierAlpha c = new ClassifierAlpha(1255);
    	Set<Integer> factors = c.factors();
    	System.out.println(factors);
    	int sum = sum(factors);
    	System.out.println(sum);
    }
}