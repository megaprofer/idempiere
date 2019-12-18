package org.alquimiasoft.logger.manager;

import java.util.logging.Level;

import org.alquimiasoft.logger.template.LoggerTemplate;

public interface LoggerManager {

	void writeLoggerTemplate(LoggerTemplate loggerTemplate);
	
	void writeLoggerTemplate(LoggerTemplate loggerTemplate, Level level);
	

}
