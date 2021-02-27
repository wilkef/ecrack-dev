package com.wilkef.ecrack.setup.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.admin.dao.ManageSubjectDao;
import com.wilkef.ecrack.setup.admin.dto.ManageSubjectDTO;
import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@RestController
@RequestMapping("/admin")
public class ManageSubjectController {

	private static final Logger LOG = Logger.getLogger(ManageSubjectController.class.getName());

	@Autowired
	private ManageSubjectDao subjectService;

	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@Autowired
	private ValidationDao validationDao;

	@Autowired
	private HttpServletRequest req;

	@GetMapping(value = "getSubjectList/{gradeId}")
	public ResponseEntity<Object> getSubjectList(@PathVariable("gradeId") Integer gradeId) {
		LOG.log(Level.INFO, () -> "Start getSubjectList Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> subjectList = subjectService.getSubjectList(gradeId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, subjectList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getSubjectList Controller");
		return response;
	}

	@PostMapping(value = "/saveSubject")
	public ResponseEntity<Object> saveSubject(@RequestBody ManageSubjectDTO data) {
		LOG.log(Level.INFO, () -> "Start saveSubject");
		LOG.log(Level.INFO, () -> "DATA:" + data);

		LoggedinUserInfo loggedinUserInfo = validationDao
				.getLoggedinUserInfo(req.getHeader(WilkefConstants.AUTH_HEADER));

		ResponseEntity<Object> response = null;
		try {
			subjectService.saveSubject(data, loggedinUserInfo.getName());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End saveSubject");
		return response;
	}

	@GetMapping(value = "/getSubjectDetails/{subjectId}")
	public ResponseEntity<Object> getSubjectDetails(@PathVariable Integer subjectId) {
		LOG.log(Level.INFO, () -> "Start getSubjectDetails");
		ResponseEntity<Object> response = null;
		try {
			ManageSubjectDTO item = subjectService.getSubjectDetails(subjectId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, item));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getSubjectDetails");
		return response;
	}

}
