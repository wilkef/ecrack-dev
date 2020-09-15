package com.wilkef.ecrack.setup.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.wilkef.ecrack.setup.dto.UnitDataDTO;

@Repository
public interface UnitDao {

	public List<UnitDataDTO> getUnitDetails();

}
