/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.SubjectDataDTO;


/**
 * The Interface SubjectService.
 *
 * @author chinmaya.dehury
 * This interface will be holding all the service methods related to Subject.
 */
public interface SubjectService {
	
	/**
	 * Gets the subjects by grade id.
	 *
	 * @param gradeId the grade id
	 * @return the subjects by grade id
	 */
	public List<SubjectDataDTO> getSubjectsByGradeId(Integer gradeId);

}
