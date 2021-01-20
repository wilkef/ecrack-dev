package com.wilkef.ecrack.setup.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.wilkef.ecrack.setup.admin.dto.TestInfoDTO;
import com.wilkef.ecrack.setup.admin.dto.ExamList;
import com.wilkef.ecrack.setup.admin.dto.McqDTO;
import com.wilkef.ecrack.setup.admin.dto.McqFilterDTO;
import com.wilkef.ecrack.setup.admin.dto.TestLineDTO;

public interface ManageExamDao {
	
	public TestInfoDTO getExamInfo(Integer examId);
	
	@SuppressWarnings("rawtypes")
	public List<HashMap> getExamDetails(Integer examId);

	@SuppressWarnings("rawtypes")
	public List<HashMap> getExamSubjectsDetails(Integer testHeaderId);

	@SuppressWarnings("rawtypes")
	public List<HashMap> getMCQList(McqFilterDTO data);
	
	public Integer getMcqCount();

	@SuppressWarnings("rawtypes")
	public List<HashMap> getMCQData(McqFilterDTO data);

	public Boolean updateTestLineQuestionSet(TestLineDTO data, String username);

	public Boolean saveMCQ(McqDTO data, String username);

	public Integer saveExam(TestInfoDTO data, String username);

	public List<ExamList> getExamList();

	public McqDTO getMCQDetails(Integer mcqId);
}
