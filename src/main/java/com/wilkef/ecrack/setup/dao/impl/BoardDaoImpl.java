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
import com.wilkef.ecrack.setup.dao.BoardDao;
import com.wilkef.ecrack.setup.dto.BoardDataDto;

/**
 * @author Satya Oct 3, 2020
 */
@Repository
public class BoardDaoImpl implements BoardDao {
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(BoardDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardDataDto> getBoard() {
		LOG.fine("get board Details ");
		List<BoardDataDto> subjectListData = new ArrayList<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(appJdbcTemplate)
					.withProcedureName(WilkefConstants.BOARD_INFO)
					.returningResultSet("BoardResultSet", BeanPropertyRowMapper.newInstance(BoardDataDto.class));

			Map<String, Object> execute = simpleJdbcCall.execute();
			subjectListData = (List<BoardDataDto>) execute.get("BoardResultSet");

		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for board list");
		}
		return subjectListData;
	}
}
