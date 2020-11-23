/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * The Class AnswerStatusDataDTO.
 *
 * @author Satya Sep 20, 2020
 */
public class AnswerStatusDataDTO {

	/** The answer status id. */
	private Integer answerStatusId;

	/** The status. */
	private String status;

	/**
	 * Gets the answer status id.
	 *
	 * @return the answer status id
	 */
	public Integer getAnswerStatusId() {
		return answerStatusId;
	}

	/**
	 * Sets the answer status id.
	 *
	 * @param answerStatusId the new answer status id
	 */
	public void setAnswerStatusId(Integer answerStatusId) {
		this.answerStatusId = answerStatusId;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AnswerStatusDataDTO [answerStatusId=" + answerStatusId + ", status=" + status + "]";
	}

}
