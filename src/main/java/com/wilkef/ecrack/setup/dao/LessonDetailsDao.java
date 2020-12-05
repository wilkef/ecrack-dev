/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import com.wilkef.ecrack.setup.dto.LessonDetailsDataDto;

/**
 * @author Satya
 * Nov 2, 2020
 */
public interface LessonDetailsDao {
	public LessonDetailsDataDto getLessonDetails(Integer lessonId);
}
