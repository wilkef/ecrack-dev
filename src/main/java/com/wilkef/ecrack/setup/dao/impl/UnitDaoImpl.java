/**
 * @author chinmaya.dehury
 * This class provide the implementation to fetch the unit details from database.
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
import com.wilkef.ecrack.setup.dao.UnitDao;
import com.wilkef.ecrack.setup.dto.UnitDataDTO;

@Repository
public class UnitDaoImpl implements UnitDao {

	public static final Logger LOG = Logger.getLogger(UnitDaoImpl.class.getName());
	List<UnitDataDTO> unitDataList = new ArrayList<>();

	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public List<UnitDataDTO> getUnitDetails() {
		LOG.fine("get Unit details ");
		RowMapper<UnitDataDTO> rowMapper = (ResultSet result, int rowNum) -> {
			UnitDataDTO unitData = new UnitDataDTO();
			unitData.setUnitId(result.getInt(1));
			unitData.setUnitName(result.getString(2));
			unitData.setSubjectId(result.getInt(3));
			return unitData;
		};
		try {
			unitDataList = appJdbcTemplate.query(WilkefConstants.GET_UNIT_DETAIL, rowMapper);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for unit list");
		}
		return unitDataList;
	}

}
