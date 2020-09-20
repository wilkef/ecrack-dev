/*
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to Record not found Exception
 *
 */
 
package com.wilkef.ecrack.setup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class RecordNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException{

	
	/**
	 * Instantiates a new record not found exception.
	 *
	 * @param exception the exception
	 */
	public RecordNotFoundException(String exception) {
        super(exception);
    }
	
}
