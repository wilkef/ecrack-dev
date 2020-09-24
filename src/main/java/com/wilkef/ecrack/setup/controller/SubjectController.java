
/**
 * This Class is Used to execute Subject Execution
 * 
 * 
 * @author Satya 
 * Sep 16, 2020
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
import com.wilkef.ecrack.setup.dto.SubjectDataDTO;
import com.wilkef.ecrack.setup.exception.CustomException;
import com.wilkef.ecrack.setup.service.SubjectService;


/**
 * The Class SubjectController.
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(SubjectController.class.getName());

	/** The subject service. */
	@Autowired
	private SubjectService subjectService;

	/**
	 * Find by grade id.
	 *
	 * @param gradeId the grade id
	 * @return the response entity
	 */
	@GetMapping(value = "/subjectList/{GradeId}")
	public ResponseEntity<Object> findByGradeId(@PathVariable("GradeId") Integer gradeId) {
		LOG.info("START-Inside findByGradeId");
		LOG.log(Level.INFO, () -> " findByGradeId Inputs gradeId:"+gradeId); 
		ResponseEntity<Object> response = null;
		List<SubjectDataDTO> subjectDataList = null;
		try {
			LOG.log(Level.INFO, () -> "Before geting Subject information based on gradeId : " + gradeId);
			subjectDataList = subjectService.getSubjectsByGradeId(gradeId);
			if (!subjectDataList.isEmpty()) {
				response = new ResponseEntity<>(subjectDataList, HttpStatus.OK);
			} else {
				LOG.log(Level.INFO, () -> "Subject Record is Not There in DB " );
				throw new CustomException(ErrorConstants.NO_RECORD_FOUND);
			}
		}	
		catch (Exception e) {
			LOG.log(Level.SEVERE,
					() -> ErrorConstants.SMTHNG_WNT_WRONG + e.getMessage());
		}
		LOG.info("END-Inside findByGradeId");
		return response;
	}
}
