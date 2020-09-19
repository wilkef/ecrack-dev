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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.dto.UnitListDataDTO;
import com.wilkef.ecrack.setup.service.UnitListService;

/**
 * @author Satya
 *Sep 18, 2020
 */

@RestController
@RequestMapping("subject")
public class UnitListController {
	
	public static final Logger LOG = Logger.getLogger(UnitListController.class.getName());

	@Autowired
	private UnitListService unitListService;
	
	@GetMapping(value = "/unitList/{SubjectId}")	
	public ResponseEntity<?> findByClassId(@PathVariable("SubjectId") Integer subjectId) {

		ResponseEntity<?> response = null;
		List<UnitListDataDTO> unitListData = null;

		LOG.info("Inside find the UnitList based on subjectId");
		try {
			LOG.log(Level.INFO, () -> "Before geting UnitList information based on subjectId : " + subjectId);
			unitListData = unitListService.findBySubjectId(subjectId);
			if (!unitListData.isEmpty()) {
				response = new ResponseEntity<>(unitListData, HttpStatus.OK);
				return response;
			} else {
				response = new ResponseEntity<>("Record Not Found ", HttpStatus.OK);
				return response;
			}
		}	
		catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> "something wrong while fetching the information based on subjectId : " + e.getMessage());
		}
		return response;
	}
}
