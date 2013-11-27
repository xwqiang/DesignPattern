package com.designPattern.activeobj.active;

import com.designPattern.activeobj.Service;
import com.designPattern.activeobj.ServiceImp;

public class ServiceProxy implements Service{
	private Service _service;
    private ActiveObject _active_object;
    public ServiceProxy() {
        _service = new ServiceImp();
        _active_object = new ActiveObject();
    }
	public void sayHello() {
		MethodRequest mr = new SayHello(_service);
		_active_object.enqueue(mr);
	}

}
