package com.wilkef.ecrack.setup.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.wilkef.ecrack.setup.admin.dto.ManageSubjectDTO;

public interface ManageSubjectDao {
	@SuppressWarnings("rawtypes")
	public List<HashMap> getSubjectList(Integer gradeId);
	
	public Boolean saveSubject(ManageSubjectDTO data, String username);

	public ManageSubjectDTO getSubjectDetails(Integer subjectId);
}
