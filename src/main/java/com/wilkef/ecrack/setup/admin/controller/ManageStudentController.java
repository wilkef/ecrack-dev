package com.wilkef.ecrack.setup.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.admin.dao.ManageStudentDao;
import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@RestController
@RequestMapping("/admin")
public class ManageStudentController {
	private static final Logger LOG = Logger.getLogger(ManageStudentController.class.getName());

	@Autowired
	private ManageStudentDao studentService;

	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@GetMapping(value = "getStudentList")
	public ResponseEntity<Object> getStudentList() {
		LOG.log(Level.INFO, () -> "Start getStudentList Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> studentList = studentService.getStudentList();
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, studentList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getStudentList Controller");
		return response;
	}

}
