package com.webautomation.dataprovider;

import java.util.HashMap;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webautomation.constants.FrameworkConstants;

public class JSONDataProvider {

	@DataProvider(name = "jsondata")
	public static Object[] getData() throws JsonMappingException, JsonProcessingException {

		HashMap<String, Object> map = new ObjectMapper().readValue(FrameworkConstants.getJsonpath(),
				new TypeReference<HashMap<String, Object>>() {
				});
		return new Object[] {map};

	}
}
