/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.UnitListDataDTO;

/**
 * @author Satya
 *Sep 18, 2020
 */

public interface UnitListDao {
	public List<UnitListDataDTO> findBySubjectId(Integer subjectId);
}
