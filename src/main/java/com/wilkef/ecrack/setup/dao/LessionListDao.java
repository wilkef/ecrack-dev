/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.LessionListDataDTO;

/**
 * @author Satya
 *Sep 18, 2020
 */
public interface LessionListDao {
	public List<LessionListDataDTO> findByUnitId(Integer unitId);
}
