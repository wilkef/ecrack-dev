package com.wilkef.ecrack.setup.dto;

import org.json.JSONObject;

public class UserProfileDTO {
	
	

	private String dataOutput;
	private Integer updateCount;

	public Integer getUpdateCount() {
		return updateCount;
	}

	public void setUpdateCount(Integer updateCount) {
		this.updateCount = updateCount;
	}

	public String getDataOutput() {
		return dataOutput;
	}

	public void setDataOutput(String dataOutput) {
		this.dataOutput = dataOutput;
	}
	
}
