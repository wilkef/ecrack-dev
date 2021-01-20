/**
 * 
 */
package com.wilkef.ecrack.setup.dao.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

	@Autowired
	private JdbcTemplate appJdbcTemplate;

	@Override
	public LessonDetailsDataDto getLessonDetails(Integer lessonId) {
		LessonDetailsDataDto lessonDetails = new LessonDetailsDataDto();
		try {
			return appJdbcTemplate.queryForObject(WilkefConstants.LESSON_DETAILS, new Object[] { lessonId },
					(result, rowNum) -> {
						lessonDetails.setSubjectName(result.getString(1));
						lessonDetails.setSubjectId(result.getInt(2));
						lessonDetails.setUnitId(result.getInt(3));
						lessonDetails.setUnitName(result.getString(4));
						lessonDetails.setLessonName(result.getString(5));
						lessonDetails.setVideoUrl(result.getString(6));
						lessonDetails.setLessonThumbnail(result.getString(7));
						lessonDetails.setIsFavorite(result.getInt(8) > 0 ? true : false);
						return lessonDetails;
					});
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return lessonDetails;
	}
}
