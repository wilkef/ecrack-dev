package com.wilkef.ecrack.setup.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.wilkef.ecrack.setup.admin.dto.ManageBoardDTO;
import com.wilkef.ecrack.setup.admin.dto.ManageLessonDTO;

public interface ManageBoardDao {
	@SuppressWarnings("rawtypes")
	public List<HashMap> getBoardList();
	
	public Boolean saveBoard(ManageBoardDTO data, String username);

	public ManageBoardDTO getBoardDetails(Integer boardId);
}
