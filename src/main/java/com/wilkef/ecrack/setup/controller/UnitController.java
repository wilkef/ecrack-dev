package com.wilkef.ecrack.setup.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wilkef.ecrack.setup.dao.EcrackDao;
import com.wilkef.ecrack.setup.dto.UnitDataDTO;

@Controller
@RequestMapping("service")
public class UnitController {


	
	@Autowired
	private EcrackDao ecrackDao;
	

	
	
	@GetMapping("/getUnitData")
	public @ResponseBody String getUnit(@RequestParam (required =false) String input ) {
		JSONObject obj= new JSONObject();
		obj.put("Data", "Sample");
		obj.put("MessageToUser", "Data Received Successfully");
		return obj.toString();
		
	}
	
	@GetMapping("/getUnitDataFromTable")
	public @ResponseBody String getData() {
		JSONObject obj= new JSONObject();
		JSONArray array=new JSONArray();
		List<UnitDataDTO> data=ecrackDao.getUnitDetails();
		for(UnitDataDTO  dto: data) {
			JSONObject ob=new JSONObject();
			ob.put("unitId", dto.getUnitId());
			ob.put("unitName",dto.getUnitName());
			ob.put("subjectId", dto.getSubjectId());
			array.put(ob);
		}
		obj.put("Data", array);
		obj.put("MessageToUser", "Data Received Successfully");
		return obj.toString();
		
	}
	
}
