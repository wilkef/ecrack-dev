/**
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *        global handling of exception
 *
 */

package com.wilkef.ecrack.setup.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The Class CustomExceptionHandler.
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handle all exceptions.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
		String error = ex.getLocalizedMessage();
		return buildResponseEntity(new ErrorResponse(HttpStatus.OK, error, ex));
	}

	/**
	 * Handle user not found exception.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(CustomException ex) {
		String error = ex.getLocalizedMessage();
		return buildResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND, error, ex));
	}

	/**
	 * Handle method argument not valid.
	 *
	 * @param ex      the ex
	 * @param headers the headers
	 * @param status  the status
	 * @param request the request
	 * @return the response entity
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		return buildResponseEntity(new ErrorResponse(HttpStatus.EXPECTATION_FAILED, details.toString(), ex));
	}

	/**
	 * Handle number format exception.
	 *
	 * @return the response entity
	 */
	@ExceptionHandler(NumberFormatException.class)
	public final ResponseEntity<Object> handleNumberFormatException(Exception e) {
		String error = "Invalid Request Input";
		return buildResponseEntity(new ErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, error, e));
	}

	private ResponseEntity<Object> buildResponseEntity(ErrorResponse apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}
