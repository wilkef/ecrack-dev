package com.wilkef.ecrack.setup.admin.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wilkef.ecrack.setup.admin.dao.ManageUnitDao;
import com.wilkef.ecrack.setup.admin.dto.ManageUnitDTO;
import com.wilkef.ecrack.setup.exception.CustomException;

@Repository
@Transactional
public class ManageUnitDaoImpl implements ManageUnitDao {

	public static final Logger LOG = Logger.getLogger(ManageUnitDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HashMap> getUnitList(Integer UnitId) {
		List<HashMap> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getUnitList DAO");
		try {
			String query = "SELECT u.UnitId, u.UnitName, u.MaxMark, u.NoOfPeriod, u.IsActive, s.UnitName FROM Unit u "
					+ "JOIN Unit s ON(s.UnitId=u.UnitId) WHERE u.UnitId=? ORDER BY u.UnitSerial ASC";
			appJdbcTemplate.query(query, new Object[] { UnitId }, (result, rowNum) -> {
				HashMap item = new HashMap<>();
				item.put("unitId", result.getInt("UnitId"));
				item.put("unitName", result.getString("UnitName"));
				item.put("maxMark", result.getInt("MaxMark"));
				item.put("noOfPeriod", result.getInt("NoOfPeriod"));
				item.put("isActive", result.getInt("IsActive") > 0 ? true : false);
				item.put("UnitName", result.getString("UnitName"));
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Unit List:" + e.getMessage());
			throw new CustomException("Error while fetching Unit List:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getUnitList DAO");
		return list;
	}

	@Override
	public Boolean saveUnit(ManageUnitDTO data, String username) {
		try {
			if (data.getUnitId() != null && data.getUnitId() > 0) {
				String query = "UPDATE `Unit` SET `UnitName`=? WHERE UnitId=?";
				appJdbcTemplate.update(query, data.getUnitName(), data.getUnitId());
			} else {
				String query = "INSERT INTO `Unit` (`UnitName`) VALUES (?)";
				appJdbcTemplate.update(query, data.getUnitName());
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while creating a new Unit:" + e.getMessage());
			throw new CustomException("Error while creating a new Unit:" + e.getMessage());
		}
		return true;
	}

	@Override
	public ManageUnitDTO getUnitDetails(Integer unitId) {
		ManageUnitDTO item = new ManageUnitDTO();
		LOG.log(Level.INFO, () -> "Start getUnitDetails");
		try {
			String query = "SELECT UnitId, UnitName FROM Unit WHERE UnitId=?";
			appJdbcTemplate.query(query, new Object[] { unitId }, (rs, rowNum) -> {
				item.setUnitId(rs.getInt("UnitId"));
				return item;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Unit Details:" + e.getMessage());
			throw new CustomException("Error while fetching Unit Details:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getUnitDetails");
		return item;
	}

}
