/**
 * This Class is Used to Execute TestType Execution
 * 
 * @author Satya
 *Sep 20, 2020
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
import com.wilkef.ecrack.setup.dto.TestTypeListDataDTO;
import com.wilkef.ecrack.setup.exception.CustomExceptionHandler;
import com.wilkef.ecrack.setup.service.TestTypeListService;

/**
 * The Class TestTypeListController.
 */
@RestController
@RequestMapping("/exam")
public class TestTypeListController {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(TestTypeListController.class.getName());

	/** The type list service. */
	@Autowired
	private TestTypeListService typeListService;

	/**
	 * Find all test type list.
	 *
	 * @return the response entity
	 */
	@GetMapping("/testTypeList")
	public ResponseEntity<Object> findAllTestTypeList() {
		LOG.info("START-Inside findAllTestTypeList");
		LOG.log(Level.INFO, () -> "No findAllTestTypeList Inputs gradeId");
		ResponseEntity<Object> response = null;
		List<TestTypeListDataDTO> findAllTestTypeList = null;
		try {
			LOG.log(Level.INFO, () -> "Before Fetching TestTypeList : ");
			findAllTestTypeList = typeListService.findAllTestTypeList();
			response = new ResponseEntity<>(findAllTestTypeList, HttpStatus.OK);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, () -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
			return new CustomExceptionHandler().handleAllExceptions(e);
		}
		LOG.info("START-Inside findAllTestTypeList");
		return response;
	}
}
