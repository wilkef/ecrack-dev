/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.BoardDao;
import com.wilkef.ecrack.setup.dto.BoardDataDto;
import com.wilkef.ecrack.setup.service.BoardService;

/**
 * This Class is Used to Execute Board List Service Class Implementation.
 * 
 * @author Satya
 *Oct 3, 2020
 */

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(BoardServiceImpl.class.getName());
	
	/**
	 * Find all board list.
	 *
	 * @return the list
	 */
	@Override
	public List<BoardDataDto> getBoard() {
		List<BoardDataDto> boardDetails=null;
		try {
			boardDetails = boardDao.getBoard();
		} catch (Exception exception) {
			LOG.log(Level.SEVERE, () -> "something wrong while Working With Board List : " + exception.getMessage());
		}
		return boardDetails;
	}

}
