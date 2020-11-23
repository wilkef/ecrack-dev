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
import com.wilkef.ecrack.setup.dao.LessonDetailsDao;
import com.wilkef.ecrack.setup.dto.LessonDetailsDataDto;

/**
 * @author Satya Nov 2, 2020
 */

@Repository
public class LessonDetailsDaoImpl implements LessonDetailsDao {

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(LessonDetailsDaoImpl.class.getName());

	/** The app jdbc template. */
	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public List<LessonDetailsDataDto> getAllLessonDetails(Integer lessonId) {

		List<LessonDetailsDataDto> lessondetailsList = new ArrayList<>();
		RowMapper<LessonDetailsDataDto> rowMapper = (ResultSet result, int rowNum) -> {
			LessonDetailsDataDto lessondetails = new LessonDetailsDataDto();
			lessondetails.setSubjectName(result.getString(1));
			lessondetails.setSubjectId(result.getInt(2));
			lessondetails.setUnitId(result.getInt(3));
			lessondetails.setUnitName(result.getString(4));
			lessondetails.setLessonName(result.getString(5));
			lessondetails.setVideoUrl(result.getString(6));
			lessondetails.setLessonThumbnail(result.getString(7));
			return lessondetails;
		};
		try {
			lessondetailsList = appJdbcTemplate.query(WilkefConstants.LESSON_DETAILS, rowMapper, lessonId);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error while fetching records for LessonDetails");
		}
		return lessondetailsList;
	}
}
