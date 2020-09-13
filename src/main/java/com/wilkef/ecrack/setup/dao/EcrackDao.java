package com.wilkef.ecrack.setup.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wilkef.ecrack.setup.dto.UnitDataDTO;

@Transactional
@Repository
public class EcrackDao {

	
	@Autowired
	private JdbcTemplate appJdbcTemplate;
	
		
	
	public List<UnitDataDTO> getUnitDetails(){
		List<UnitDataDTO> unitData= appJdbcTemplate.query("Select UnitId ,UnitName ,SubjectId from ecrack.Unit", new RowMapper<UnitDataDTO>(){
		public UnitDataDTO mapRow(ResultSet result,int rowNum) throws SQLException{
			UnitDataDTO unitData=new UnitDataDTO();
			unitData.setUnitId(String.valueOf(result.getInt("UnitId")));
			unitData.setUnitName(result.getString("UnitName"));
			unitData.setSubjectId(String.valueOf(result.getInt("SubjectId")));
			return unitData;
		}
		});
		return unitData;
	}
	
	
	
	
	
}
