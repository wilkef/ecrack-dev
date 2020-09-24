package com.wilkef.ecrack.setup.dto;

import org.springframework.http.HttpStatus;


/**
 * The Class CommonResponseDTO.
 */
public class CommonResponseDTO {
	
	/** The is success. */
	private boolean isSuccess;
	

	 /**
 	 * Checks if is success.
 	 *
 	 * @return true, if is success
 	 */
 	public boolean isSuccess() {
		return isSuccess;
	}

	/**
	 * Sets the success.
	 *
	 * @param isSuccess the new success
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/** The status. */
	private String status ;

	    /** The data. */
    	private Object data;

	    /** The error. */
    	private String error;

	    /** The status code. */
    	private HttpStatus statusCode ;

		/**
		 * Gets the status code.
		 *
		 * @return the status code
		 */
		public HttpStatus getStatusCode() {
			return statusCode;
		}

		/**
		 * Sets the status code.
		 *
		 * @param statusCode the new status code
		 */
		public void setStatusCode(HttpStatus statusCode) {
			this.statusCode = statusCode;
		}

		/**
		 * Gets the status.
		 *
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * Sets the status.
		 *
		 * @param status the new status
		 */
		public void setStatus(String status) {
			this.status = status;
		}

		/**
		 * Gets the data.
		 *
		 * @return the data
		 */
		public Object getData() {
			return data;
		}

		/**
		 * Sets the data.
		 *
		 * @param data the new data
		 */
		public void setData(Object data) {
			this.data = data;
		}

		/**
		 * Gets the error.
		 *
		 * @return the error
		 */
		public String getError() {
			return error;
		}

		/**
		 * Sets the error.
		 *
		 * @param error the new error
		 */
		public void setError(String error) {
			this.error = error;
		}

		
}
