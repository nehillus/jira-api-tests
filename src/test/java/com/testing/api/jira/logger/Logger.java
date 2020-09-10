package com.testing.api.jira.logger;

import org.apache.logging.log4j.LogManager;


public class Logger {
	
	private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(Logger.class.getName());
	
	public static void info(Object obj) {
		LOGGER.info(obj);
	}
	
	public static void error(Object obj) {
		LOGGER.error(obj);
	}
	
	public static void trace(Object obj) {
		LOGGER.trace(obj);
	}	
	
	public static void warn(Object obj) {
		LOGGER.warn(obj);
	}	
	
	public static void fatal(Object obj) {
		LOGGER.fatal(obj);
	}
	
	public static void debug(Object... obj) {
		LOGGER.debug(obj);
	}
}
