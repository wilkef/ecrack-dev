package com.wilkef.ecrack.setup.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
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
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.wilkef.ecrack.setup.dto.ProfileDTO;
import com.wilkef.ecrack.setup.admin.dao.AdminDao;
import com.wilkef.ecrack.setup.admin.dto.TestInfoDTO;
import com.wilkef.ecrack.setup.admin.dto.ExamList;
import com.wilkef.ecrack.setup.admin.dto.McqDTO;
import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private static final Logger LOG = Logger.getLogger(AdminController.class.getName());

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@Autowired
	private ValidationDao validationDao;

	@Autowired
	private HttpServletRequest req;

	@PutMapping(value = "toggleStatus/{table}/{id}/{status}")
	public ResponseEntity<Object> toggleStatus(@PathVariable("table") String table, @PathVariable("id") Integer id,
			@PathVariable("status") Integer status) {
		LOG.log(Level.INFO, () -> "Start toggleStatus Controller");
		ResponseEntity<Object> response = null;
		try {
			adminDao.toggleStatus(table, id, status);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End toggleStatus Controller");
		return response;
	}

	@GetMapping(value = "getStudentList")
	public ResponseEntity<Object> getStudentList() {
		LOG.log(Level.INFO, () -> "Start getStudentList Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> studentList = adminDao.getStudentList();
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, studentList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getStudentList Controller");
		return response;
	}

	@GetMapping(value = "getBoardList")
	public ResponseEntity<Object> getBoardList() {
		LOG.log(Level.INFO, () -> "Start getBoardList Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> boardList = adminDao.getBoardList();
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, boardList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getBoardList Controller");
		return response;
	}

	@GetMapping(value = "getGradeList/{boardId}")
	public ResponseEntity<Object> getGradeList(@PathVariable("boardId") Integer boardId) {
		LOG.log(Level.INFO, () -> "Start getGradeList Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> gradeList = adminDao.getGradeList(boardId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, gradeList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, e.getMessage()));
		}
		LOG.log(Level.INFO, () -> "End getGradeList Controller");
		return response;
	}

	@GetMapping(value = "getSubjectList/{gradeId}")
	public ResponseEntity<Object> getSubjectList(@PathVariable("gradeId") Integer gradeId) {
		LOG.log(Level.INFO, () -> "Start getSubjectList Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> subjectList = adminDao.getSubjectList(gradeId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, subjectList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getSubjectList Controller");
		return response;
	}

	@GetMapping(value = "getUnitList/{subjectId}")
	public ResponseEntity<Object> getUnitList(@PathVariable("subjectId") Integer subjectId) {
		LOG.log(Level.INFO, () -> "Start getUnitList Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> unitList = adminDao.getUnitList(subjectId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, unitList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getUnitList Controller");
		return response;
	}

	@GetMapping(value = "getLessonList/{unitId}")
	public ResponseEntity<Object> getLessonList(@PathVariable("unitId") Integer unitId) {
		LOG.log(Level.INFO, () -> "Start getLessonList Controller");
		ResponseEntity<Object> response = null;
		try {
			@SuppressWarnings("rawtypes")
			List<HashMap> lessonList = adminDao.getLessonList(unitId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, lessonList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getLessonList Controller");
		return response;
	}

}
