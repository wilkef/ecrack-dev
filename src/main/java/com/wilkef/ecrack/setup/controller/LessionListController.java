/**
 *  This Class is Identify to execute Lession Controller Operation
 * 
 * @author Satya
 *Sep 18, 2020
 */
package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.dto.LessionListDataDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.LessionListService;



/**
 * The Class LessionListController.
 */
@RestController
@RequestMapping("/subject")
public class LessionListController {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(LessionListController.class.getName());

	/** The lession service. */
	@Autowired
	private LessionListService lessionService;

	/**
	 * Find by grade id.
	 *
	 * @param unitId the unit id
	 * @return the response entity
	 */
	@GetMapping(value = "/lessionList/{UnitId}")
	public ResponseEntity<Object> findByGradeId(@PathVariable("UnitId") Integer unitId) {
		LOG.info("START-Inside findByGradeId ");
		LOG.log(Level.INFO, () -> "updateProfile Inputs unitId: "+unitId); 
		ResponseEntity<Object> response = null;
		List<LessionListDataDTO> lessionList = null;
		try {
			lessionList = lessionService.findByUnitId(unitId);
			response = new ResponseEntity<>(lessionList, HttpStatus.OK);
		}	
		catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("START-Inside findByGradeId ");
		return response;
	}
}
