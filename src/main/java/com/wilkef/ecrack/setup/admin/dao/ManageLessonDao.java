package com.wilkef.ecrack.setup.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.wilkef.ecrack.setup.admin.dto.ManageExamDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageLessonDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageMcqDTO;
import com.wilkef.ecrack.setup.admin.dto.TestInfoDTO;

public interface ManageLessonDao {
	@SuppressWarnings("rawtypes")
	public List<HashMap> getLessonList(Integer unitId);
	
	public Boolean saveLesson(ManageLessonDTO data, String username);

	public ManageLessonDTO getLessonDetails(Integer lessonId);
}
