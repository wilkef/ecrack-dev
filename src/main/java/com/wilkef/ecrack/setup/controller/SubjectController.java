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

import com.wilkef.ecrack.setup.dto.SubjectDataDTO;
import com.wilkef.ecrack.setup.service.SubjectService;

/**
 * This Class is Used to execute Subject Execution
 * 
 * 
 * @author Satya Sep 16, 2020
 */

@RestController
@RequestMapping("/subject")
public class SubjectController {

	public static final Logger LOG = Logger.getLogger(SubjectController.class.getName());

	@Autowired
	private SubjectService subjectService;

	@GetMapping(value = "/getAllSubject/{GradeId}")
	public ResponseEntity<?> findByGradeId(@PathVariable("GradeId") Integer gradeId) {

		ResponseEntity<?> response = null;
		List<SubjectDataDTO> subjectDataList = null;

		LOG.info("Inside find the Subject based on gradeId");
		try {
			LOG.log(Level.INFO, () -> "Before geting Subject information based on gradeId : " + gradeId);
			subjectDataList = subjectService.getSubjectsByGradeId(gradeId);
			if (!subjectDataList.isEmpty()) {
				response = new ResponseEntity<>(subjectDataList, HttpStatus.OK);
				return response;
			} else {
				response = new ResponseEntity<>("Record Not Found ", HttpStatus.OK);
				return response;
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> "something wrong while fetching the information based on gradeId : " + e.getMessage());
		}
		return response;
	}
}
