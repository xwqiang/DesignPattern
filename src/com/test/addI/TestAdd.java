package com.test.addI;

public class TestAdd {

    public static void main(String[] args) {

        int i=3;

        int j=(i++)+(i++);    //5,7

        //int j=(++i)+(++i);  //5,9

        System.out.println(i+","+j);

    }

}
