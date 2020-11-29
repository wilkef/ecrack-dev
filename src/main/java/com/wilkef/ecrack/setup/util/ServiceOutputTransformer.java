/**
 * /***
 * 
 * @author Rajani Suprava This class is created to contain all the information
 *        
 *
 */
package com.wilkef.ecrack.setup.util;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

/**
 * The Class ServiceOutputTransformer.
 */
@Component
public class ServiceOutputTransformer {

	public enum Response {
		isSuccess, data, message;
	}

	static HashMap responseHashMap;

	public static HashMap getInitialHashMap() {
		return new HashMap<>();
	}

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

	public String apiResponse(Boolean status) {
		responseHashMap = ServiceOutputTransformer.getInitialHashMap();
		responseHashMap.put(Response.isSuccess, status);
		return new Gson().toJson(responseHashMap);
	}

	public String apiResponse(Boolean status, Object data) {
		responseHashMap = ServiceOutputTransformer.getInitialHashMap();
		responseHashMap.put(Response.isSuccess, status);
		responseHashMap.put(Response.data, data);
		return new Gson().toJson(responseHashMap);
	}

	public String apiResponse(Boolean status, Object data, String message) {
		responseHashMap = ServiceOutputTransformer.getInitialHashMap();
		responseHashMap.put(Response.isSuccess, status);
		responseHashMap.put(Response.data, data);
		responseHashMap.put(Response.message, message);
		return new Gson().toJson(responseHashMap);
	}
}
