package com.wilkef.ecrack.setup.admin.dao;

import java.util.HashMap;
import java.util.List;

public interface AdminDao {

//	@SuppressWarnings("rawtypes")
//	public List<HashMap> getExamDetails(Integer examId);
//	
//	@SuppressWarnings("rawtypes")
//	public List<HashMap> getExamSubjectsDetails(Integer testHeaderId);
//	
//	@SuppressWarnings("rawtypes")
//	public List<HashMap> getMCQList();
//	
//	@SuppressWarnings("rawtypes")
//	public List<HashMap> getMCQData(McqFilterDTO data);
//	
//	public Boolean toggleStatus(String table, Integer id, Integer status);
//	
//	Boolean updateTestLineQuestionSet(TestLineDTO data, String username);
//	
//	Boolean saveMCQ(McqDTO data, String username);
//	
//	Boolean saveExam(CreateExamDTO data, String username);
//	
//	public List<ExamList> getExamList();
//	
//	McqDTO getMCQDetails(Integer mcqId);

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

	public Boolean toggleStatus(String table, Integer id, Integer status);

}
