/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import org.json.JSONObject;

import com.wilkef.ecrack.setup.dto.RegistrationDataDTO;

/**
 * @author Satya
 * Sep 20, 2020
 */
public interface RegistrationDao {
	public List<RegistrationDataDTO> save(JSONObject obj);
}
