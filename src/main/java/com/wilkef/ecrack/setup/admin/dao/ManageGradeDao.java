package com.wilkef.ecrack.setup.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.wilkef.ecrack.setup.admin.dto.ManageBoardDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageGradeDTO;

public interface ManageGradeDao {
	@SuppressWarnings("rawtypes")
	public List<HashMap> getGradeList(Integer boardId);
	
	public Boolean saveGrade(ManageGradeDTO data, String username);

	public ManageGradeDTO getGradeDetails(Integer gradeId);
}
