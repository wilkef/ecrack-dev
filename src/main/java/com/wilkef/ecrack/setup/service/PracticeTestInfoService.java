/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import org.json.JSONObject;

import com.wilkef.ecrack.setup.dto.PracticeTestInfoDTO;

/**
 * This interface will be holding all the service methods related to
 * PracticeTestInfo.
 * 
 * @author Satya Sep 21, 2020
 */
public interface PracticeTestInfoService {

	/**
	 * Find practice test info.
	 *
	 * @param obj the obj
	 * @return the list
	 */
	public List<PracticeTestInfoDTO> findPracticeTestInfo(JSONObject obj);
}
