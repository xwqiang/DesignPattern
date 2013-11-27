package com.designPattern.oberver;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SimpleListener implements PropertyChangeListener {
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.getPropertyName()+"±ä»¯:"+evt.getOldValue()+"--->"+evt.getNewValue());
		 if(evt.getPropertyName().equals("Domain.name")){   
	          System.out.println(".............");
        }else{
        	System.out.println("22222222222222222");
        }
	}   
    
       
   
}  