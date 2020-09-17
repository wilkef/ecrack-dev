package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.SubjectDataDTO;

/**
 * @author Satya
 *Sep 16, 2020
 */

public interface SubjectDao {
	public List<SubjectDataDTO> findByGradeId(Integer gradeId);
}
