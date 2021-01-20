package com.wilkef.ecrack.setup.admin.dto;

public class McqFilterDTO {
	private Integer boardId;
	private Integer gradeId;
	private Integer subjectId;
	private Integer unitId;
	private Long lessonId;
	private String query;
	private Integer page;
	private Integer limit;

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "McqFilterDTO [boardId=" + boardId + ", gradeId=" + gradeId + ", subjectId=" + subjectId + ", unitId="
				+ unitId + ", lessonId=" + lessonId + ", query=" + query + "]";
	}

}
