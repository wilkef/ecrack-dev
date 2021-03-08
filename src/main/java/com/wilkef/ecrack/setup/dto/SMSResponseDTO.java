/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Chinmaya.dehury
 *
 *         08-Mar-2021
 *
 */
public class SMSResponseDTO {
	private String Status;
	private String Details;

	/**
	 * @return the status
	 */
	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return Details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		Details = details;
	}

	@Override
	public String toString() {
		return "SMSResponseDTO [Status=" + Status + ", Details=" + Details + "]";
	}

}
