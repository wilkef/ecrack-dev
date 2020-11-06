/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Satya
 * Nov 5, 2020
 */
public class AskYourDoubt {
	private Integer doubtId;
	private String studentId;
	private Integer subjectId;
	private Integer lessonId;
	private Integer status;
	private String doubt;
	private String doubtPath;
	
	public Integer getDoubtId() {
		return doubtId;
	}
	public void setDoubtId(Integer doubtId) {
		this.doubtId = doubtId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public Integer getLessonId() {
		return lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDoubt() {
		return doubt;
	}
	public void setDoubt(String doubt) {
		this.doubt = doubt;
	}
	public String getDoubtPath() {
		return doubtPath;
	}
	public void setDoubtPath(String doubtPath) {
		this.doubtPath = doubtPath;
	}
	@Override
	public String toString() {
		return "AskYourDoubt [doubtId=" + doubtId + ", studentId=" + studentId + ", subjectId=" + subjectId
				+ ", lessonId=" + lessonId + ", status=" + status + ", doubt=" + doubt + ", doubtPath=" + doubtPath
				+ "]";
	}
	
	
}
