/**
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *        
 *
 */
package com.wilkef.ecrack.setup.util;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.wilkef.ecrack.setup.constant.ErrorConstants;

/**
 * The Class ServiceOutputTransformer.
 */
@Component
public class ServiceOutputTransformer {

	/**
	 * Crate output.
	 *
	 * @param data the data
	 * @param code the code
	 * @return the JSON object
	 */
	public JSONObject crateOutput(Object data, String code) {
		JSONObject response = new JSONObject();
		response.put("status", code);
		response.put("output", data);
		response.put("message", "Data Retreved Successfully.");
		return response;
	}

	/**
	 * Response output.
	 *
	 * @param key the key
	 * @param val the val
	 * @return the JSON object
	 */
	public String responseOutput(String key, Object val) {
		JSONObject response = new JSONObject();
		response.put(key, val);
		return response.toString();
	}
	
	public String apiResponse(Boolean status, String data) {
		JSONObject response = new JSONObject();
		response.put(ErrorConstants.API_STATUS, status);
		response.put(ErrorConstants.API_DATA, data);
		return response.toString();
	}

	public String apiResponse(Boolean status, String data, String message) {
		JSONObject response = new JSONObject();
		response.put(ErrorConstants.API_STATUS, status);
		response.put(ErrorConstants.API_DATA, data);
		response.put(ErrorConstants.API_MESSAGE, message);
		return response.toString();
	}
}
