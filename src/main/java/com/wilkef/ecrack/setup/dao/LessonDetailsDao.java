/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.LessonDetailsDataDto;

/**
 * @author Satya
 * Nov 2, 2020
 */
public interface LessonDetailsDao {
	public List<LessonDetailsDataDto> getAllLessonDetails(Integer lessonId);
}
