/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.UnitListDao;
import com.wilkef.ecrack.setup.dto.UnitListDataDTO;
import com.wilkef.ecrack.setup.service.UnitListService;


/**
 * This class provides implementation for UnitListService interface to get the unitList details based on subjectId ID.
 * 
 * @author Satya
 *Sep 18, 2020
 */

@Service
public class UnitListServiceImpl implements UnitListService{

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger(UnitListServiceImpl.class.getName());

	/** The unit list dao. */
	@Autowired
	private UnitListDao unitListDao;
	
	/**
	 * Find by subject id.
	 *
	 * @param subjectId the subject id
	 * @return the list
	 */
	@Override
	public List<UnitListDataDTO> findBySubjectId(Integer subjectId) {
		List<UnitListDataDTO> unitListData = null;
		try {
			unitListData = unitListDao.findBySubjectId(subjectId);
			} catch(Exception exception) {
				LOG.log(Level.SEVERE, () -> "something wrong while fetching the data based on subjectId : " + exception.getMessage());
			}
			return unitListData;
	}

}
