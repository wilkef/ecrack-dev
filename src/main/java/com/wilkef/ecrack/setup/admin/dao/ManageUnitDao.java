package com.wilkef.ecrack.setup.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.wilkef.ecrack.setup.admin.dto.ManageSubjectDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageUnitDTO;

public interface ManageUnitDao {
	@SuppressWarnings("rawtypes")
	public List<HashMap> getUnitList(Integer subjectId);
	
	public Boolean saveUnit(ManageUnitDTO data, String username);

	public ManageUnitDTO getUnitDetails(Integer unitId);
}
