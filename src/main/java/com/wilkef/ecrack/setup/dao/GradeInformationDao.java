/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.GradeInformationDTO;

/**
 * @author Chinmaya.dehury
 *
 * 29-Sep-2020
 *
 */
public interface GradeInformationDao {

	public List<GradeInformationDTO> fetchGradeInformationByBoard(int boardId);
}
