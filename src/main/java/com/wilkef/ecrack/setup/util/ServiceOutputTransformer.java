package com.wilkef.ecrack.setup.util;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ServiceOutputTransformer {

	
	public JSONObject crateOutput(Object data,String code) {
		JSONObject response=new JSONObject();
		//JSONObject fbj=new JSONObject(data);
		response.put("status", code);
		response.put("output", data);
		response.put("message", "Data Retreved Successfully.");
		return response;
	}
}