/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.UnitListDataDTO;

/**
 * The Interface UnitListService.
 *
 * @author Satya Sep 18, 2020
 */
public interface UnitListService {

	/**
	 * Find by subject id.
	 *
	 * @param subjectId the subject id
	 * @return the list
	 */
	public List<UnitListDataDTO> findBySubjectId(Integer subjectId);
}
