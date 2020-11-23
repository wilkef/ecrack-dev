/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.CityListDao;
import com.wilkef.ecrack.setup.dto.CityListDataDTO;

/**
 * @author Satya Oct 25, 2020
 */

@Repository
public class CityListDaoImpl implements CityListDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(CityListDaoImpl.class.getName());

	/** The question level data list. */
	List<CityListDataDTO> cityList = new ArrayList<>();

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	/**
	 * Find question level.
	 *
	 * @return the list
	 */
	@Override
	public List<CityListDataDTO> getCityList() {
		LOG.fine("get QuestionLevel details ");
		RowMapper<CityListDataDTO> rowMapper = (ResultSet result, int rowNum) -> {
			CityListDataDTO cityListData = new CityListDataDTO();
			cityListData.setValue(result.getInt(1));
			cityListData.setName(result.getString(2));
			return cityListData;
		};
		try {
			cityList = appJdbcTemplate.query(WilkefConstants.GET_CITY_LIST, rowMapper);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for questionLevel list");
		}
		return cityList;
	}
}
