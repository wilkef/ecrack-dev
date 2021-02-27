package com.wilkef.ecrack.setup.admin.dao;

import java.util.List;

import com.wilkef.ecrack.setup.admin.dto.ManageInstructorDTO;

public interface AdminDao {

	public List<ManageInstructorDTO> getInstructorList();

	public Boolean toggleStatus(String table, Integer id, Integer status);

	public Boolean addInstructor(ManageInstructorDTO data, String username);
	
	public Boolean deleteInstructor(Integer instructorId);

}
