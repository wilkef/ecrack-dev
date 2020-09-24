package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.SubjectDataDTO;

/**
 * The Interface SubjectDao.
 *
 * @author Satya
 * Sep 16, 2020
 */

public interface SubjectDao {
	
	/**
	 * Find by grade id.
	 *
	 * @param gradeId the grade id
	 * @return the list
	 */
	public List<SubjectDataDTO> findByGradeId(Integer gradeId);
}
