package com.designPattern.oberver;

public class SimpleTest{   
    public static void main(String[] args) {   
        SimpleListener listener = new SimpleListener();   
        Domain domain = new Domain();   
        domain.addPropertyChangeListener(listener);   
        domain.setName("aaa");
        
        domain.setName("bbb");   
    }   
}  