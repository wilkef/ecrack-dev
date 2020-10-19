/**
 * This Class is Used to execute UnitList Execution
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
import com.wilkef.ecrack.setup.dto.UnitListDataDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.UnitListService;


/**
 * The Class UnitListController.
 */
@RestController
@RequestMapping("/subject")
public class UnitListController {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(UnitListController.class.getName());

	/** The unit list service. */
	@Autowired
	private UnitListService unitListService;

	/**
	 * Find by class id.
	 *
	 * @param subjectId the subject id
	 * @return the response entity
	 */
	@GetMapping(value = "/unitList/{SubjectId}")	
	public ResponseEntity<Object> findByClassId(@PathVariable("SubjectId") Integer subjectId) {
		LOG.info("START-Inside findByClassId");
		LOG.log(Level.INFO, () -> " findByClassId Inputs subjectId: "+subjectId); 
		ResponseEntity<Object> response = null;
		List<UnitListDataDTO> unitListData = null;

		LOG.info("Inside find the UnitList based on subjectId");
		try {
			LOG.log(Level.INFO, () -> "Before geting UnitList information based on subjectId : " + subjectId);
			unitListData = unitListService.findBySubjectId(subjectId);
			response = new ResponseEntity<>(unitListData, HttpStatus.OK);
		}	
		catch (Exception e) {
			LOG.log(Level.SEVERE,() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("END-Inside findByClassId");
		return response;
	}
}
