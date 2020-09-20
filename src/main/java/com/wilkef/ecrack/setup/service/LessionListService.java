/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.LessionListDataDTO;

/**
 * This interface will be holding all the service methods related to LessionList.
 * 
 * @author Satya
 *Sep 18, 2020
 */

public interface LessionListService {
	public List<LessionListDataDTO> findByUnitId(Integer unitId);
}
