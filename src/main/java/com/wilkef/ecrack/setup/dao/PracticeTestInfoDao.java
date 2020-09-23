/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import org.json.JSONObject;

import com.wilkef.ecrack.setup.dto.PracticeTestInfoDTO;

/**
 * @author Satya
 *Sep 21, 2020
 */
public interface PracticeTestInfoDao {
	public List<PracticeTestInfoDTO> findPracticeTestInfo(JSONObject obj);
}
