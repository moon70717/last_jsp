package com.last.jsp.factory;


import java.util.HashMap;
import java.util.Map;

import com.last.jsp.service.Service;
import com.last.jsp.service.impl.MenuServiceImpl;
import com.last.jsp.service.impl.UserServiceImpl;

public class ServiceFactory {

	private static Map<String,Service> serviceMap=new HashMap<String,Service>();
	
	private ServiceFactory() {
		
	}
	
	public static ServiceFactory getInstance() {
		return new ServiceFactory();
	}
	
	private void initIntance(String serviceName) {
		if(serviceName.equals("menu")) {
			serviceMap.put(serviceName, new MenuServiceImpl());
		} else if(serviceName.equals("user")) {
			serviceMap.put(serviceName, new UserServiceImpl());
		}
	}
	
	public Service getService(String serviceName) {
		if(!serviceMap.containsKey(serviceName)) {
			initIntance(serviceName);
			
		}
		return serviceMap.get(serviceName);
	}
}
