package com.wilkef.ecrack.setup.dao;

import java.util.HashMap;
import java.util.List;

public interface AdminDao {
	
	@SuppressWarnings("rawtypes")
	public List<HashMap> getStudentList();
	
	@SuppressWarnings("rawtypes")
	public List<HashMap> getBoardList();
	
	@SuppressWarnings("rawtypes")
	public List<HashMap> getGradeList(Integer boardId);
	
	@SuppressWarnings("rawtypes")
	public List<HashMap> getSubjectList(Integer gradeId);
	
	@SuppressWarnings("rawtypes")
	public List<HashMap> getUnitList(Integer subjectId);

	@SuppressWarnings("rawtypes")
	public List<HashMap> getLessonList(Integer unitId); 
}
