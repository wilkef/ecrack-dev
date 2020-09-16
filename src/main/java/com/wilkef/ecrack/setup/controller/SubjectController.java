package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wilkef.ecrack.setup.dao.SubjectDao;
import com.wilkef.ecrack.setup.dto.SubjectDataDTO;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	public static final Logger LOG = Logger.getLogger(SubjectController.class.getName());
	
	@Autowired
	private SubjectDao subjectDao;
	
	@Autowired
	private ServiceOutputTransformer serviceOutputTransformer;
	
	@GetMapping(value = "/getAllSubject/{GradeId}")
	public @ResponseBody String findByGradeId(@PathVariable("GradeId")Integer gradeId){
		LOG.info("Input is GradeId");
		List<SubjectDataDTO> subjectDataList = subjectDao.findByGradeId(gradeId);
		return serviceOutputTransformer.crateOutput(subjectDataList, "200").toString();
	}
}
