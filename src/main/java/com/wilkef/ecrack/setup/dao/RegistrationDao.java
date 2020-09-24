/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import org.json.JSONObject;

import com.wilkef.ecrack.setup.dto.RegistrationDataDTO;

/**
 * The Interface RegistrationDao.
 *
 * @author Satya
 * Sep 20, 2020
 */
public interface RegistrationDao {
	
	/**
	 * Save.
	 *
	 * @param obj the obj
	 * @return the list
	 */
	public List<RegistrationDataDTO> save(JSONObject obj);
}
