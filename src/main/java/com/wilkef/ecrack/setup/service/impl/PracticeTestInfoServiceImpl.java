/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.PracticeTestInfoDao;
import com.wilkef.ecrack.setup.dto.PracticeTestInfoDTO;
import com.wilkef.ecrack.setup.service.PracticeTestInfoService;


/**
 * This class provides implementation for PracticeTestInfoService interface to get the PracticeTestInfo details .
 * 
 * @author Satya
 *Sep 21, 2020
 */

@Service
public class PracticeTestInfoServiceImpl implements PracticeTestInfoService{

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(PracticeTestInfoServiceImpl.class.getName());
	
	/** The practice test info dao. */
	@Autowired
	private PracticeTestInfoDao practiceTestInfoDao;
	
	/**
	 * Find practice test info.
	 *
	 * @param obj the obj
	 * @return the list
	 */
	@Override
	public List<PracticeTestInfoDTO> findPracticeTestInfo(JSONObject obj) {
		List<PracticeTestInfoDTO> practiceTestInfo = null;

		try {
			practiceTestInfo = practiceTestInfoDao.findPracticeTestInfo(obj);
		} catch(Exception exception) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the data based on practiceTestInfo : " + exception.getMessage());
		}
		return practiceTestInfo;
	}
}
