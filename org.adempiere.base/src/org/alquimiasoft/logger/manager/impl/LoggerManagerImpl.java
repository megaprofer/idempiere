package org.alquimiasoft.logger.manager.impl;

import java.util.logging.Level;

import org.alquimiasoft.logger.manager.LoggerManager;
import org.alquimiasoft.logger.template.LoggerTemplate;
import org.compiere.util.CLogger;

public class LoggerManagerImpl implements LoggerManager{

//	private static final Logger LOGGER = (Logger) LogManager.getLogger("MAIN_LOGGER");
	private final static CLogger log = CLogger.getCLogger(LoggerManager.class);
	
	public LoggerManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void writeLoggerTemplate(LoggerTemplate loggerTemplate) {
//		LOGGER.info(loggerTemplate.buildLoggerMessage());
		log.log(Level.WARNING, loggerTemplate.buildLoggerMessage());
//		System.out.println(loggerTemplate.buildLoggerMessage());
	}
	
	@Override
	public void writeLoggerTemplate(LoggerTemplate loggerTemplate, Level level) {
//		LOGGER.info(loggerTemplate.buildLoggerMessage());
		log.log(level, loggerTemplate.buildLoggerMessage());
//		System.out.println(loggerTemplate.buildLoggerMessage());
	}

}
