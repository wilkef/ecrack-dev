/**
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *         related to creation of Error response
 *
 */

package com.wilkef.ecrack.setup.exception;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * The Class ErrorResponse.
 */
@XmlRootElement(name = "error")
public class ErrorResponse {

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDebugMessage() {
		return debugMessage;
	}
	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
	private ErrorResponse() {
		timestamp = LocalDateTime.now();
	}
	ErrorResponse(HttpStatus status) {
		this();
		this.status = status;
	}

	ErrorResponse(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	ErrorResponse(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}
}
