package org.adempiere.rest.service;

import java.util.UUID;

public interface RestService {
	Object doService(String event, UUID trackId, String jsonValue, String method);
	
	Object getData(String event, UUID trackId, String jsonValue, String method);
}
