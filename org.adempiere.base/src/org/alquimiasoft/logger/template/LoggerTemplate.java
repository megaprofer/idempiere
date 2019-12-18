package org.alquimiasoft.logger.template;

public interface LoggerTemplate {

	String buildLoggerMessage();
	
	LoggerTemplate level(String level);

}
