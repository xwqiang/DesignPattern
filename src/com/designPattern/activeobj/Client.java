package com.designPattern.activeobj;

public class Client {
	private Service _service;
	public Client(Service s){
		this._service = s;
	}
	public void requestService() {
        _service.sayHello();
    }
}
