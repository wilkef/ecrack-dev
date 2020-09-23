/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.AnswerStatusDataDTO;

/**
 * @author Satya
 *Sep 20, 2020
 */
public interface AnswerStatusDao {
	public List<AnswerStatusDataDTO> findAllAnswerStatus();
}
