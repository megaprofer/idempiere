package com.alquimiasoft.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class RSApplication extends Application {
	
	public Set<Class<?>> getClasses() {
		Set<Class<?>> webServices = new HashSet<Class<?>>();
		String isWsEnabled = System.getenv().get("WS_ENABLED");
		if (isWsEnabled != null && isWsEnabled.toString().toUpperCase().equals("Y")) {
			webServices.add(WebService.class);
		}
		return webServices;
	}
	
}
