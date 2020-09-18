/**
 * 
 */
package com.wilkef.ecrack.setup.service;

import java.util.List;

import com.wilkef.ecrack.setup.dto.SubjectDataDTO;

/**
 * @author chinmaya.dehury
 * This interface will be holding all the service methods related to Subject.
 *
 */
public interface SubjectService {
	public List<SubjectDataDTO> getSubjectsByGradeId(Integer gradeId);

}
