/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.TestTypeListDao;
import com.wilkef.ecrack.setup.dto.TestTypeListDataDTO;

/**
 * This Class is Used to execute DB operation of TestTypeList.
 *
 * @author Satya Sep 20, 2020
 */

@Repository
public class TestTypeListDaoImpl implements TestTypeListDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(TestTypeListDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	/**
	 * Find all test type list.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TestTypeListDataDTO> findAllTestTypeList() {
		List<TestTypeListDataDTO> testTypeDataList = new ArrayList<>();
		LOG.fine("get TetsTypeList details ");
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.TEST_TYPE_LIST)
					.returningResultSet("TestTypeList", BeanPropertyRowMapper.newInstance(TestTypeListDataDTO.class));

			Map<String, Object> execute = simpleJdbcCall.execute();
			testTypeDataList = (List<TestTypeListDataDTO>) execute.get("TestTypeList");
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for TestTypeList ");
		}
		return testTypeDataList;
	}
}
