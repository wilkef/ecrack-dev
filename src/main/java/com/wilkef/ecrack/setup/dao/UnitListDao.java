/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.UnitListDataDTO;

/**
 * The Interface UnitListDao.
 *
 * @author Satya
 * Sep 18, 2020
 */

public interface UnitListDao {
	
	/**
	 * Find by subject id.
	 *
	 * @param subjectId the subject id
	 * @return the list
	 */
	public List<UnitListDataDTO> findBySubjectId(Integer subjectId);
}
