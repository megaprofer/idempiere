package org.adempiere.rest.service;

public class ServiceNotFoundException extends RuntimeException{

	public ServiceNotFoundException(String message) {
		super(message);
	}

}