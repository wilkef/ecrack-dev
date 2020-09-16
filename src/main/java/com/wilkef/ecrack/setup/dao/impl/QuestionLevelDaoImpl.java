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
import org.springframework.transaction.annotation.Transactional;

import com.wilkef.ecrack.setup.constant.WilkefConstants;
import com.wilkef.ecrack.setup.dao.QuestionLevelDao;
import com.wilkef.ecrack.setup.dto.QuestionLevelDataDTO;

@Repository
@Transactional
public class QuestionLevelDaoImpl implements QuestionLevelDao{

	public static final Logger LOG = Logger.getLogger(QuestionLevelDaoImpl.class.getName());
	List<QuestionLevelDataDTO> questionLevelDataList = new ArrayList<>();
	
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public List<QuestionLevelDataDTO> findQuestionLevel() {
		LOG.fine("get QuestionLevel details ");
		RowMapper<QuestionLevelDataDTO> rowMapper = (ResultSet result, int rowNum) -> {
			QuestionLevelDataDTO questionLevelData = new QuestionLevelDataDTO();
			questionLevelData.setDifficultyId(result.getInt(1));
			questionLevelData.setDifficultyCode(result.getString(2));
			return questionLevelData;
		};
		try {
			questionLevelDataList = appJdbcTemplate.query(WilkefConstants.GET_QUESTIONLEVEL_DETAIL, rowMapper);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for questionLevel list");
		}
		return questionLevelDataList;
	}
}
