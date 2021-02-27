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

import com.wilkef.ecrack.setup.admin.dao.ManageBoardDao;
import com.wilkef.ecrack.setup.admin.dto.ManageBoardDTO;
import com.wilkef.ecrack.setup.exception.CustomException;

@Repository
@Transactional
public class ManageBoardDaoImpl implements ManageBoardDao {

	public static final Logger LOG = Logger.getLogger(ManageBoardDaoImpl.class.getName());

	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HashMap> getBoardList() {
		List<HashMap> list = new ArrayList<>();
		LOG.log(Level.INFO, () -> "Start getBoardList DAO");
		try {
			String query = "SELECT BoardId, BoardName, BoardShortName, IsActive FROM Board ORDER BY BoardName ASC";
			appJdbcTemplate.query(query, new Object[] {}, (result, rowNum) -> {
				HashMap item = new HashMap<>();
				item.put("boardId", result.getInt("BoardId"));
				item.put("boardName", result.getString("BoardName"));
				item.put("boardShortName", result.getString("BoardShortName"));
				item.put("isActive", result.getInt("IsActive") > 0 ? true : false);
				list.add(item);
				return list;
			});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching Board list:" + e.getMessage());
			throw new CustomException("Error while fetching Board list:" + e.getMessage());
		}
		LOG.log(Level.INFO, () -> "End getBoardList DAO");
		return list;
	}
	
	@Override
	public Boolean saveBoard(ManageBoardDTO data, String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ManageBoardDTO getBoardDetails(Integer boardId) {
		// TODO Auto-generated method stub
		return null;
	}

}
