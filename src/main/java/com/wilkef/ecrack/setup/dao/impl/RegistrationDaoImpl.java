/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.RegistrationDao;
import com.wilkef.ecrack.setup.dto.RegistrationDataDTO;

/**
 * This Class is Used to execute Registration DB Operation.
 *
 * @author Satya Sep 20, 2020
 */

@Repository
public class RegistrationDaoImpl implements RegistrationDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(RegistrationDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	/**
	 * Save.
	 *
	 * @param obj the obj
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RegistrationDataDTO> save(JSONObject obj) {
		LOG.fine("Store User Details ");
		List<RegistrationDataDTO> registrationStatus = null;
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.REGISTRATION).returningResultSet("RegistrationResultSet",
							BeanPropertyRowMapper.newInstance(RegistrationDataDTO.class));
			Map<String, Object> execute = simpleJdbcCall.execute(obj);
			registrationStatus = (List<RegistrationDataDTO>) execute.get("RegistrationResultSet");
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while Inserting User Record ");
		}
		return registrationStatus;
	}
}
