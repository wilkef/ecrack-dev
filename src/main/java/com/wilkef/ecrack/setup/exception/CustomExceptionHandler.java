/*
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
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	
	 /**
 	 * Handle all exceptions.
 	 *
 	 * @param ex the ex
 	 * @return the response entity
 	 */
 	@ExceptionHandler(Exception.class)
	    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("Server Error", details);
	        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
	    /**
    	 * Handle user not found exception.
    	 *
    	 * @param ex the ex
    	 * @return the response entity
    	 */
    	@ExceptionHandler(CustomException.class)
	    public final ResponseEntity<Object> handleUserNotFoundException(CustomException ex) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("Data Not Found", details);
	        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	    }
	 
	    /**
    	 * Handle method argument not valid.
    	 *
    	 * @param ex the ex
    	 * @param headers the headers
    	 * @param status the status
    	 * @param request the request
    	 * @return the response entity
    	 */
    	@Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
	            details.add(error.getDefaultMessage());
	        }
	        ErrorResponse error = new ErrorResponse("Validation Failed", details);
	        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	    }
	    
	    
	 
    	/**
	     * Handle number format exception.
	     *
	     * @return the response entity
	     */
	    @ExceptionHandler(NumberFormatException.class)
	    public final ResponseEntity<Object> handleNumberFormatException() {
	        List<String> details = new ArrayList<>();
	        ErrorResponse error = new ErrorResponse("Invalid Request Input", details);
	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	    }
	 
}
