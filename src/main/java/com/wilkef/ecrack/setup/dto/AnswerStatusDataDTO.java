/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Satya
 *Sep 20, 2020
 */
public class AnswerStatusDataDTO {
	private Integer answerStatusId; 
	private String status;
	
	public Integer getAnswerStatusId() {
		return answerStatusId;
	}
	public void setAnswerStatusId(Integer answerStatusId) {
		this.answerStatusId = answerStatusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AnswerStatusDataDTO [answerStatusId=" + answerStatusId + ", status=" + status + "]";
	}
	
}
