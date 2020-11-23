/**
 * 
 */
package com.wilkef.ecrack.setup.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Class LogUtil.
 *
 * @author chinmaya.dehury
 */
public class LogUtil {

	/** The Constant loggerThread. */
	public static final ThreadLocal<Logger> loggerThread = new ThreadLocal<>();

	/**
	 * Instantiates a new log util.
	 */
	private LogUtil() {}

	/**
	 * Debug.
	 *
	 * @param message the message
	 * @param object  the object
	 */
	public static synchronized void debug(String message, Object object) {
		message = format(message, object);
		Logger log = getLogger(object);
		log.debug(message);

	}

	/**
	 * Info.
	 *
	 * @param message the message
	 * @param object  the object
	 */
	public static synchronized void info(String message, Object object) {
		message = format(message, object);
		Logger log = getLogger(object);
		log.info(message);

	}

	/**
	 * Error.
	 *
	 * @param message the message
	 * @param object  the object
	 */
	public static synchronized void error(String message, Object object) {
		message = format(message, object);
		Logger log = getLogger(object);
		StringBuilder errorLog = new StringBuilder("Thread : " + Thread.currentThread().getId() + " / ");
		log.error(errorLog.append(message));

	}

	/**
	 * Error.
	 *
	 * @param message   the message
	 * @param exception the exception
	 * @param object    the object
	 */
	public static synchronized void error(String message, Exception exception, Object object) {
		message = format(message, object);
		Logger log = getLogger(object);
		StringBuilder errorLog = new StringBuilder("Thread : " + Thread.currentThread().getId() + " / ");
		log.error(errorLog.append(message), exception);

	}

	/**
	 * Gets the logger.
	 *
	 * @param object the object
	 * @return the logger
	 */
	public static synchronized Logger getLogger(Object object) {
		Logger log = loggerThread.get();
		if (log == null) {
			log = LogManager.getLogger(object.getClass());
			loggerThread.set(log);
		}
		return log;
	}

	/**
	 * Gets the level.
	 *
	 * @param object the object
	 * @return the level
	 */
	public static Level getLevel(Object object) {
		Logger log = getLogger(object.getClass());
		return log.getLevel();
	}

	/**
	 * Format.
	 *
	 * @param message the message
	 * @param object  the object
	 * @return the string
	 */
	public static String format(String message, Object object) {
		String className = object.getClass().getName();
		message = className + " - " + message;
		return message;
	}
}
