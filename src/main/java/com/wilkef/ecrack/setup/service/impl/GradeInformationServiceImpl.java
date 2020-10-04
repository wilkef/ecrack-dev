/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.GradeInformationDao;
import com.wilkef.ecrack.setup.dto.GradeInformationDTO;
import com.wilkef.ecrack.setup.service.GradeInformationService;

/**
 * @author Chinmaya.dehury
 *
 *         29-Sep-2020
 *
 */

@Service
public class GradeInformationServiceImpl implements GradeInformationService {

	public static final Logger LOG = Logger.getLogger(GradeInformationServiceImpl.class.getName());
	@Autowired
	private GradeInformationDao gradeInfoDao;

	private List<GradeInformationDTO> gradeInfoList = null;

	@Override
	public List<GradeInformationDTO> getGradeInformation(int boardId) {
		LOG.log(Level.INFO, () -> "Board ID as parameter : : " + boardId);
		try {
			gradeInfoList = gradeInfoDao.fetchGradeInformationByBoard(boardId);
		} catch (Exception exception) {
			LOG.log(Level.SEVERE,
					() -> "Exception occured while fetching data from database : : " + exception.getMessage());
		}

		return gradeInfoList;
	}

}
