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

import com.wilkef.ecrack.setup.dao.RegistrationDao;
import com.wilkef.ecrack.setup.dto.RegistrationDataDTO;
import com.wilkef.ecrack.setup.service.RegistrationService;


/**
 * This class provides implementation for Registration interface to store the user details.
 * 
 * @author Satya
 * Sep 20, 2020
 */

@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(RegistrationServiceImpl.class.getName());
	
	/** The register dao. */
	@Autowired
	private RegistrationDao registerDao;

	/**
	 * Save.
	 *
	 * @param obj the obj
	 * @return the list
	 */
	@Override
	public List<RegistrationDataDTO> save(JSONObject obj) {
		List<RegistrationDataDTO> save=null;
		try {
			save = registerDao.save(obj);
		} catch (Exception exception) {
			LOG.log(Level.SEVERE, () -> "something wrong while inserting User Record : " + exception.getMessage());
		} 
		return save;
	}
}
