/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import org.json.JSONObject;

import com.wilkef.ecrack.setup.dto.RegistrationDataDTO;


/**
 * This interface will be holding all the service methods related to Registration.
 * 
 * @author Satya
 * Sep 20, 2020
 */
public interface RegistrationService {
	
	/**
	 * Save.
	 *
	 * @param obj the obj
	 * @return the list
	 */
	public List<RegistrationDataDTO> save(JSONObject obj);
}
