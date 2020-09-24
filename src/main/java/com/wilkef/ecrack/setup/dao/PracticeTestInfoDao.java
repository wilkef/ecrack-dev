/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import org.json.JSONObject;

import com.wilkef.ecrack.setup.dto.PracticeTestInfoDTO;

/**
 * The Interface PracticeTestInfoDao.
 *
 * @author Satya
 * Sep 21, 2020
 */
public interface PracticeTestInfoDao {
	
	/**
	 * Find practice test info.
	 *
	 * @param obj the obj
	 * @return the list
	 */
	public List<PracticeTestInfoDTO> findPracticeTestInfo(JSONObject obj);
}
