package com.wilkef.ecrack.setup.dao;

import org.json.JSONArray;
import org.springframework.stereotype.Repository;

@FunctionalInterface
@Repository
public interface UnitDao {

	public JSONArray getUnitDetails( );
	/*
	 * @Autowired private JdbcTemplate appJdbcTemplate;
	 * 
	 * public List<UnitDataDTO> getUnitDetails() { RowMapper<UnitDataDTO>
	 * rowMapper=( ResultSet result, int rowNum) -> { UnitDataDTO unitData=new
	 * UnitDataDTO(); unitData.setUnitId(String.valueOf(result.getInt("UnitId")));
	 * unitData.setUnitName(result.getString("UnitName"));
	 * unitData.setSubjectId(String.valueOf(result.getInt("SubjectId"))); return
	 * unitData; }; List<UnitDataDTO> unitData=
	 * appJdbcTemplate.query("Select UnitId ,UnitName ,SubjectId from ecrack.Unit",
	 * rowMapper); return unitData; }
	 */

	
	
	
	
	
}
