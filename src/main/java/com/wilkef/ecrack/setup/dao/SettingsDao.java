package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.InstructorDTO;

public interface SettingsDao {
	public List<InstructorDTO> getInstructors();
}
