package com.wilkef.ecrack.setup.service;

import java.util.List;

import javax.validation.Valid;

import com.wilkef.ecrack.setup.dto.QuizTestDTO;

public interface ExamService {

	List<QuizTestDTO> getScheduledTest(@Valid Integer gradeId);




}
