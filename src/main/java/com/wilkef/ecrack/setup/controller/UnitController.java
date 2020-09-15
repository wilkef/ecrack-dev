package com.wilkef.ecrack.setup.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wilkef.ecrack.setup.constant.UnitConstants;
import com.wilkef.ecrack.setup.dao.UnitDao;
import com.wilkef.ecrack.setup.dto.UnitDataDTO;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

@Controller
@RequestMapping("service")
public class UnitController {
	public static final Logger LOG=Logger.getLogger(UnitController.class.getName());

	@Autowired private JdbcTemplate appJdbcTemplate;
	
	
	@Autowired private ServiceOutputTransformer serviceOutputTransformer;
	
	@GetMapping("/getUnitData")
	public @ResponseBody String getUnit(@RequestParam (required =false) String input ) {
		JSONObject obj= new JSONObject();
		obj.put("Data", "Sample");
		obj.put("MessageToUser", "Data Received Successfully");
		return obj.toString();
		
	}
	
	@GetMapping("/getUnitDataFromTable")
	public @ResponseBody String getData() {
		LOG.info("No input");
		JSONArray array=new JSONArray();
		UnitDao eCrackDao= ()->{
			List<JSONObject> unitData= appJdbcTemplate.query(UnitConstants.GET_UNIT_DETAIL, new RowMapper<JSONObject>(){
				public JSONObject mapRow(ResultSet result,int rowNum) throws SQLException{
					JSONObject ob=new JSONObject();
					ob.put(UnitConstants.UNIT_ID,String.valueOf(result.getInt(UnitConstants.UNIT_ID)));
					ob.put(UnitConstants.UNIT_NM,result.getString(UnitConstants.UNIT_NM));
					ob.put(UnitConstants.SUB_ID,String.valueOf(result.getInt(UnitConstants.SUB_ID)));
					return ob;
				}
				});
			unitData.forEach(ob -> {array.put(ob); });
				return  array;
		};
		 eCrackDao.getUnitDetails();
		 return serviceOutputTransformer.crateOutput(array, "200").toString();
	}
	
}
