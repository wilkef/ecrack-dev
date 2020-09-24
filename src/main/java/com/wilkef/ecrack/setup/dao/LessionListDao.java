/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.LessionListDataDTO;

/**
 * The Interface LessionListDao.
 *
 * @author Satya
 * Sep 18, 2020
 */
public interface LessionListDao {
	
	/**
	 * Find by unit id.
	 *
	 * @param unitId the unit id
	 * @return the list
	 */
	public List<LessionListDataDTO> findByUnitId(Integer unitId);
}
