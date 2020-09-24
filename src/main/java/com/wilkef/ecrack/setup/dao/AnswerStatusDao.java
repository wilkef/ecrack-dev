/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.AnswerStatusDataDTO;

/**
 * The Interface AnswerStatusDao.
 *
 * @author Satya
 * Sep 20, 2020
 */
public interface AnswerStatusDao {
	
	/**
	 * Find all answer status.
	 *
	 * @return the list
	 */
	public List<AnswerStatusDataDTO> findAllAnswerStatus();
}
