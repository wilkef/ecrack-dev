/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wilkef.ecrack.setup.dao.SubjectDao;
import com.wilkef.ecrack.setup.dto.SubjectDataDTO;
import com.wilkef.ecrack.setup.service.SubjectService;

/**
 * @author chinmaya.dehury
 * This class provides implementation for SubjectService interface to get the subject details based on grade ID.
 *
 */
@Component
public class SubjectServiceImpl implements SubjectService{
	
	public static final Logger LOG = Logger.getLogger(SubjectServiceImpl.class.getName());
	
	@Autowired
	private SubjectDao subjectDao;
	
	List<SubjectDataDTO> subjectDataList = null;
	

	@Override
	public List<SubjectDataDTO> getSubjectsByGradeId(Integer gradeId) {
		try {
		subjectDataList = subjectDao.findByGradeId(gradeId);
		} catch(Exception exception) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the data based on gradeId : " + exception.getMessage());
		}
		return subjectDataList;
	}

}