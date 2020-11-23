/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.BoardDataDto;

/**
 * The Interface BoardService.
 * 
 * @author Satya Oct 3, 2020
 */
public interface BoardService {

	/**
	 * Find all board list.
	 *
	 * @return the list
	 */
	public List<BoardDataDto> getBoard();
}
