package com.wilkef.ecrack.setup.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.wilkef.ecrack.setup.admin.dto.InstructorDTO;

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

	public List<InstructorDTO> getInstructorList();

	public Boolean toggleStatus(String table, Integer id, Integer status);

	public Boolean addInstructor(InstructorDTO data, String username);
	
	public Boolean deleteInstructor(Integer instructorId);

}
