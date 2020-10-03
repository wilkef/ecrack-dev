/**
 * 
 */
package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dto.BoardDataDto;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.BoardService;

/**
 * @author Satya
 *Oct 3, 2020
 */

@RestController
@RequestMapping("/user")
public class BoardController {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(BoardController.class.getName());

	/** The board status service. */
	@Autowired
	private BoardService boardService;

	/**
	 * Find all board type list.
	 *
	 * @return the response entity
	 */
	@GetMapping("/boardList")
	public ResponseEntity<Object> boardList(){
		LOG.info("START-Inside boardList "); 
		ResponseEntity<Object> response=null;
		List<BoardDataDto> findBoardDetails = null;
		try {
			findBoardDetails = boardService.getBoard();
			if (findBoardDetails!=null) {
				response = new ResponseEntity<>(findBoardDetails,HttpStatus.OK);
			}else {
				LOG.log(Level.INFO, () -> ErrorConstants.BOARD_STATUS );
				throw new CustomException(ErrorConstants.NO_RECORD_FOUND);
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);		
		}
		LOG.info("END-Inside boardList ");
		return response;
	}
}
