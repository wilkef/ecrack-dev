package com.wilkef.ecrack.setup.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.wilkef.ecrack.setup.admin.dto.ManageGradeDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageStudentDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageSubjectDTO;

public interface ManageStudentDao {

	@SuppressWarnings("rawtypes")
	public List<HashMap> getStudentList();
	
	
	public Boolean saveStudent(ManageStudentDTO data, String username);

	public ManageStudentDTO getStudentDetails(Integer studentId);

}
