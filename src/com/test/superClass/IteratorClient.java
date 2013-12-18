package com.test.superClass;

import java.util.ArrayList;
import java.util.List;

interface Iterator {  
    public Object next();  
    public boolean hasNext();  
}  
@SuppressWarnings("unchecked")
class ConcreteIterator implements Iterator{  
	private List list = new ArrayList();  
    private int cursor =0;  
    public ConcreteIterator(List list){  
        this.list = list;
    }  
    public boolean hasNext() {  
        if(cursor==list.size()){  
            return false;  
        }  
        return true;  
    }  
    public Object next() {  
        Object obj = null;  
        if(this.hasNext()){  
            obj = this.list.get(cursor++);  
        }  
        return obj;  
    }  
}  
interface Aggregate {  
    public void add(Object obj);  
    public void remove(Object obj);  
    public Iterator iterator();  
}  
@SuppressWarnings("unchecked")
class ConcreteAggregate implements Aggregate {  
	private List list = new ArrayList();  
    public void add(Object obj) {  
        list.add(obj);  
    }  
  
    public Iterator iterator() {  
        return new ConcreteIterator(list);  
    }  
  
    public void remove(Object obj) {  
        list.remove(obj);  
    }  
}  
public class IteratorClient {  
    public static void main(String[] args){  
        Aggregate ag = new ConcreteAggregate();  
        ag.add("小明");  
        ag.add("小红");  
        ag.add("小刚");  
        Iterator it = ag.iterator(); 
        while(it.hasNext()){  
            String str = (String)it.next();  
            System.out.println(str);  
        }  
    }  
}  