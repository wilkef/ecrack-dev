package com.wilkef.ecrack.setup.dao;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import com.wilkef.ecrack.setup.dto.McqDTO;

public interface AdminDao {
		
	@SuppressWarnings("rawtypes")
	public List<HashMap> getMCQList();
	
	public Boolean toggleStatus(String table, Integer id, Integer status);
	
	Boolean createMCQ(JSONObject data, String username);
	
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
