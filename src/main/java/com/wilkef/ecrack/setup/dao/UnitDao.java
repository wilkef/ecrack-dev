package com.wilkef.ecrack.setup.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.dto.UnitDataDTO;

/**
 * The Interface UnitDao.
 */
@Repository
public interface UnitDao {

	/**
	 * Gets the unit details.
	 *
	 * @return the unit details
	 */
	public List<UnitDataDTO> getUnitDetails();


}
