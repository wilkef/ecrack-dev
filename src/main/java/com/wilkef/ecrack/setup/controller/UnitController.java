package com.wilkef.ecrack.setup.controller;

import java.util.List;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wilkef.ecrack.setup.dao.UnitDao;
import com.wilkef.ecrack.setup.dto.UnitDataDTO;
import com.wilkef.ecrack.setup.util.ServiceOutputTransformer;

/***
 * 
 * @author
 * 
 *         This class is created to handle the requests related to unit.
 *
 */

@Controller
@RequestMapping("service")
public class UnitController {
	public static final Logger LOG = Logger.getLogger(UnitController.class.getName());

	@Autowired
	private UnitDao unitDao;

	@Autowired
	private ServiceOutputTransformer serviceOutputTransformer;

	@GetMapping("/getUnitData")
	public @ResponseBody String getUnit(@RequestParam(required = false) String input) {
		JSONObject obj = new JSONObject();
		obj.put("Data", "Sample");
		obj.put("MessageToUser", "Data Received Successfully");
		return obj.toString();

	}

	@GetMapping("/getUnitDataFromTable")
	public @ResponseBody String getData() {
		LOG.info("No input");
		List<UnitDataDTO> unitDataList = unitDao.getUnitDetails();
		return serviceOutputTransformer.crateOutput(unitDataList, "200").toString();
	}

}
