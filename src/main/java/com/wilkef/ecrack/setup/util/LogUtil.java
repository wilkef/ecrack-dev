/**
 * 
 */
package com.wilkef.ecrack.setup.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author chinmaya.dehury
 *
 */
public class LogUtil {

	public static final ThreadLocal<Logger> loggerThread = new ThreadLocal<>();

	private LogUtil() {
	}

	public static synchronized void debug(String message, Object object) {
		message = format(message, object);
		Logger log = getLogger(object);
		log.debug(message);

	}

	public static synchronized void info(String message, Object object) {
		message = format(message, object);
		Logger log = getLogger(object);
		log.info(message);

	}

	public static synchronized void error(String message, Object object) {
		message = format(message, object);
		Logger log = getLogger(object);
		StringBuilder errorLog = new StringBuilder("Thread : " + Thread.currentThread().getId() + " / ");
		log.error(errorLog.append(message));

	}

	public static synchronized void error(String message, Exception exception, Object object) {
		message = format(message, object);
		Logger log = getLogger(object);
		StringBuilder errorLog = new StringBuilder("Thread : " + Thread.currentThread().getId() + " / ");
		log.error(errorLog.append(message), exception);

	}

	public static synchronized Logger getLogger(Object object) {
		Logger log = loggerThread.get();
		if (log == null) {
			log = LogManager.getLogger(object.getClass());
			loggerThread.set(log);
		}

		return log;
	}

	public static Level getLevel(Object object) {
		Logger log = getLogger(object.getClass());
		return log.getLevel();
	}

	public static String format(String message, Object object) {
		String className = object.getClass().getName();
		message = className + " - " + message;
		return message;
	}
}
