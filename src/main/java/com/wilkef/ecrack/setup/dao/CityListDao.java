/**
 * 
 */
package com.wilkef.ecrack.setup.dao;

import java.util.List;

import com.wilkef.ecrack.setup.dto.CityListDataDTO;

/**
 * @author Satya
 *Oct 25, 2020
 */
public interface CityListDao {
	public List<CityListDataDTO> getCityList();
}
