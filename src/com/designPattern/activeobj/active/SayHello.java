package com.designPattern.activeobj.active;

import com.designPattern.activeobj.Service;

public class SayHello implements MethodRequest{
	private Service _service;
	public SayHello(Service s) {
        _service = s;
    }
	public void call() {
		_service.sayHello();
	}
}
