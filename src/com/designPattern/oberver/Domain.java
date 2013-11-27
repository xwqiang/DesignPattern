package com.designPattern.oberver;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Domain{   
    protected String id;   
    protected String name;   
    protected String desName;   
  
    protected PropertyChangeSupport listeners = new PropertyChangeSupport(this);   
  
    public String getId() {   
        return id;   
    }   
  
    public void setId(String id) {   
        this.id = id;   
        firePropertyChange("Domain.id", null, id);   
    }   
  
    public String getDesName() {   
        return desName;   
    }   
  
    public void setDesName(String desName) {  
    	String tmp = this.name;
        this.desName = desName;   
        firePropertyChange("Domain.desName", tmp, desName);   
    }   
  
    public String getName() {   
        return name;   
    }   
  
    public void setName(String name) {
    	String tmp = this.name;
        this.name = name;  
        firePropertyChange("Domain.name", tmp, name);   
    }   
  
    public void addPropertyChangeListener(PropertyChangeListener listener) {   
        listeners.addPropertyChangeListener(listener);   
    }   
  
    public void firePropertyChange(String propName, Object oldValue, Object newValue) {   
        listeners.firePropertyChange(propName, oldValue, newValue);   
    }   
  
    public void removePropertyChangeListener(PropertyChangeListener listener) {   
        listeners.removePropertyChangeListener(listener);   
    }   
}  