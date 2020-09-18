/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.UnitListDataDTO;

/**
 * @author Satya
 *Sep 18, 2020
 */
public interface UnitListService {
	public List<UnitListDataDTO> findBySubjectId(Integer subjectId);
}
