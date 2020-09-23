package com.wilkef.ecrack.setup.dto;

import org.springframework.http.HttpStatus;

public class CommonResponseDTO {
	
	private boolean isSuccess;
	

	 public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	private String status ;

	    private Object data;

	    private String error;

	    private HttpStatus statusCode ;

		public HttpStatus getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(HttpStatus statusCode) {
			this.statusCode = statusCode;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		
}
