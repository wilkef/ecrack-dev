package com.wilkef.ecrack.setup.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.admin.dao.ManageExamDao;
import com.wilkef.ecrack.setup.admin.dto.TestInfoDTO;
import com.wilkef.ecrack.setup.admin.dto.ExamList;
import com.wilkef.ecrack.setup.admin.dto.McqDTO;
import com.wilkef.ecrack.setup.admin.dto.McqFilterDTO;
import com.wilkef.ecrack.setup.admin.dto.TestLineDTO;
import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@RestController
@RequestMapping("/admin")
public class ManageExamController {

	private static final Logger LOG = Logger.getLogger(ManageExamController.class.getName());

	@Autowired
	private ManageExamDao manageExamDao;

	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@Autowired
	private ValidationDao validationDao;

	@Autowired
	private HttpServletRequest req;

	@GetMapping(value = "getExamSubjectsDetails/{testHeaderId}")
	public ResponseEntity<Object> getExamSubjectsDetails(@PathVariable Integer testHeaderId) {
		LOG.log(Level.INFO, () -> "Start getExamSubjectsDetails Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> subjectDetails = manageExamDao.getExamSubjectsDetails(testHeaderId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, subjectDetails));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getExamSubjectsDetails Controller");
		return response;
	}

	@GetMapping(value = "getExamDetails/{examId}")
	public ResponseEntity<Object> getExamDetails(@PathVariable Integer examId) {
		LOG.log(Level.INFO, () -> "Start getExamDetails Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> examDetails = manageExamDao.getExamDetails(examId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, examDetails));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getExamDetails Controller");
		return response;
	}
	
	@GetMapping(value = "getExamInfo/{examId}")
	public ResponseEntity<Object> examInfo(@PathVariable Integer examId) {
		LOG.log(Level.INFO, () -> "Start examInfo Controller");
		ResponseEntity<Object> response = null;
		try {
			TestInfoDTO mcq = manageExamDao.getExamInfo(examId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, mcq));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End examInfo Controller");
		return response;
	}

	@GetMapping(value = "getMCQList")
	public ResponseEntity<Object> getMCQList(@RequestParam Map<String, String> allRequestParams, McqFilterDTO data) {
		LOG.log(Level.INFO, () -> "Start getMCQList Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> mcqList = manageExamDao.getMCQList(data);
			Integer mcqCount = manageExamDao.getMcqCount();
			HashMap<String, Object> resData = new HashMap<String, Object>();
			resData.put("mcqList", mcqList);
			resData.put("mcqCount", mcqCount);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, resData));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getMCQList Controller");
		return response;
	}

	@GetMapping(value = "getMCQData")
	public ResponseEntity<Object> getMCQData(@RequestParam Map<String, String> allRequestParams, McqFilterDTO data) {
		LOG.log(Level.INFO, () -> "Start getMCQData Controller");
		LOG.log(Level.INFO, () -> "Filter allRequestParams:" + allRequestParams);
		LOG.log(Level.INFO, () -> "Filter Data:" + data);
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> MCQList = manageExamDao.getMCQData(data);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, MCQList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getMCQData Controller");
		return response;
	}

	@GetMapping(value = "getMCQDetails/{mcqId}")
	public ResponseEntity<Object> getMCQDetails(@PathVariable Integer mcqId) {
		LOG.log(Level.INFO, () -> "Start getMCQDetails Controller");
		ResponseEntity<Object> response = null;
		try {
			McqDTO mcq = manageExamDao.getMCQDetails(mcqId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, mcq));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getMCQDetails Controller");
		return response;
	}

	@PostMapping(value = "createMCQ")
	public ResponseEntity<Object> createMCQ(@RequestBody McqDTO data) {
		LOG.log(Level.INFO, () -> "Start createMCQ Controller");
		LOG.log(Level.INFO, () -> "DATA:" + data);

		LoggedinUserInfo loggedinUserInfo = validationDao
				.getLoggedinUserInfo(req.getHeader(WilkefConstants.AUTH_HEADER));
		
		ResponseEntity<Object> response = null;
		try {
			manageExamDao.saveMCQ(data, loggedinUserInfo.getName());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End createMCQ Controller");
		return response;
	}

	@PostMapping(value = "createExam")
	public ResponseEntity<Object> createExam(@RequestBody TestInfoDTO data) {
		LOG.log(Level.INFO, () -> "Start createExam Controller");
		LOG.log(Level.INFO, () -> "DATA:" + data);

		LoggedinUserInfo loggedinUserInfo = validationDao
				.getLoggedinUserInfo(req.getHeader(WilkefConstants.AUTH_HEADER));
		
		ResponseEntity<Object> response = null;
		try {
			Integer examId = manageExamDao.saveExam(data, loggedinUserInfo.getName());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, examId));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End createExam Controller");
		return response;
	}

	@PutMapping(value = "updateTestLineQuestionSet")
	public ResponseEntity<Object> updateTestLineQuestionSet(@RequestBody TestLineDTO data) {
		LOG.log(Level.INFO, () -> "Start updateTestLineQuestionSet Controller");
		LOG.log(Level.INFO, () -> "DATA:" + data);

		LoggedinUserInfo loggedinUserInfo = validationDao
				.getLoggedinUserInfo(req.getHeader(WilkefConstants.AUTH_HEADER));

		ResponseEntity<Object> response = null;
		try {
			manageExamDao.updateTestLineQuestionSet(data, loggedinUserInfo.getName());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End updateTestLineQuestionSet Controller");
		return response;
	}

	@GetMapping(value = "getExamList")
	public ResponseEntity<Object> getExamList() {
		LOG.log(Level.INFO, () -> "Start getExamList Controller");
		ResponseEntity<Object> response = null;
		try {
			List<ExamList> examList = manageExamDao.getExamList();
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, examList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getExamList Controller");
		return response;
	}

}
