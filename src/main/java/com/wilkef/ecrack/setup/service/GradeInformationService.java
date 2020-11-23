/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.GradeInformationDTO;

/**
 * @author Chinmaya.dehury
 *
 *         29-Sep-2020
 *
 */
public interface GradeInformationService {
	public List<GradeInformationDTO> getGradeInformation(int boardId);
}
