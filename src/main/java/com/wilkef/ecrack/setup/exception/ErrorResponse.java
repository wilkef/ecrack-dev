/*
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to creation of Error response
 *
 */
 
package com.wilkef.ecrack.setup.exception;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class ErrorResponse.
 */
@XmlRootElement(name = "error")
public class ErrorResponse {

	/**
	 * Instantiates a new error response.
	 *
	 * @param message the message
	 * @param details the details
	 */
	public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }
 
    /** The message. */
    //General error message about nature of error
    private String message;
 
    /** The details. */
    //Specific errors in API request processing
    private List<String> details;

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the details.
	 *
	 * @return the details
	 */
	public List<String> getDetails() {
		return details;
	}

	/**
	 * Sets the details.
	 *
	 * @param details the new details
	 */
	public void setDetails(List<String> details) {
		this.details = details;
	}
}
