package com.wilkef.ecrack.setup.admin.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wilkef.ecrack.setup.admin.dao.AdminDao;
import com.wilkef.ecrack.setup.admin.dao.UploadFileDao;
import com.wilkef.ecrack.setup.admin.dto.ManageInstructorDTO;
import com.wilkef.ecrack.setup.constant.ErrorConstants;
import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.ValidationDao;
import com.wilkef.ecrack.setup.dto.LoggedinUserInfo;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	private static final Logger LOG = Logger.getLogger(AdminController.class.getName());

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private ServiceOutputTransformer serviceOutput;

	@Autowired
	private UploadFileDao uploadFileService;

	@Autowired
	private ValidationDao validationDao;

	@Autowired
	private HttpServletRequest req;

	@PostMapping("/uploadFile")
	public String uploadFile(@RequestPart(value = "file") MultipartFile file, @RequestPart(value = "dir") String dir) {
		LOG.log(Level.INFO, () -> "DATA:" + file.toString());
		LOG.log(Level.INFO, () -> "Dir:" + dir);

		return this.uploadFileService.uploadFile(file, dir);
	}

	@PostMapping("/deleteFile")
	public String deleteFile(@RequestBody String fileURL) {
		return this.uploadFileService.deleteFileFromBucket(fileURL);
	}

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

	@PostMapping(value = "/deleteInstructor/{instructorId}")
	public ResponseEntity<Object> deleteInstructor(@PathVariable("instructorId") Integer instructorId) {
		LOG.log(Level.INFO, () -> "Start deleteInstructor Controller");
		ResponseEntity<Object> response = null;
		try {
			adminDao.deleteInstructor(instructorId);
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, e.getMessage()));
		}
		LOG.log(Level.INFO, () -> "End deleteInstructor Controller");
		return response;
	}

	@PostMapping(value = "addInstructor")
	public ResponseEntity<Object> addInstructor(@RequestBody ManageInstructorDTO data) {
		LOG.log(Level.INFO, () -> "Start addInstructor Controller");
		LOG.log(Level.INFO, () -> "DATA:" + data);
		ResponseEntity<Object> response = null;
		try {
			LoggedinUserInfo loggedinUserInfo = validationDao
					.getLoggedinUserInfo(req.getHeader(WilkefConstants.AUTH_HEADER));
			adminDao.addInstructor(data, loggedinUserInfo.getName());
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End addInstructor Controller");
		return response;
	}

	@GetMapping(value = "getInstructors")
	public ResponseEntity<Object> getInstructors() {
		LOG.log(Level.INFO, () -> "Start getInstructors Controller");
		ResponseEntity<Object> response = null;
		try {
			List<ManageInstructorDTO> instructorList = adminDao.getInstructorList();
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.TRUE, instructorList));
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(serviceOutput.apiResponse(Boolean.FALSE, null, ErrorConstants.SMTHNG_WNT_WRONG));
		}
		LOG.log(Level.INFO, () -> "End getInstructors Controller");
		return response;
	}

}
