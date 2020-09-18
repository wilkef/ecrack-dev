/**
 * 
 */
package com.wilkef.ecrack.setup.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkef.ecrack.setup.dao.LessionListDao;
import com.wilkef.ecrack.setup.dto.LessionListDataDTO;
import com.wilkef.ecrack.setup.service.LessionListService;

/**
 *  This class provides implementation for LessionService interface to get the Lession details based on UnitId.
 * 
 * @author Satya
 * Sep 18, 2020
 */

@Service
public class LessionListServiceImpl implements LessionListService{

	public static final Logger LOG = Logger.getLogger(LessionListServiceImpl.class.getName());

	@Autowired
	private LessionListDao lessionDao;

	@Override
	public List<LessionListDataDTO> findByUnitId(Integer unitId) {
		List<LessionListDataDTO> lessionList = null;

		try {
			lessionList = lessionDao.findByUnitId(unitId);
		} catch(Exception exception) {
			LOG.log(Level.SEVERE, () -> "something wrong while fetching the data based on unitId : " + exception.getMessage());
		}
		return lessionList;
	}
}
