/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.BoardDataDto;

/**
 * The Interface BoardDao.
 * 
 * @author Satya
 *Oct 3, 2020
 */
public interface BoardDao {
	
	/**
	 * Find all board list.
	 *
	 * @return the list
	 */
	public List<BoardDataDto> getBoard();

}
