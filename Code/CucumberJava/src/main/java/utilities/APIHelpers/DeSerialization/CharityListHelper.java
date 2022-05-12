package utilities.APIHelpers.DeSerialization;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CharityListHelper {

	/*
	 * CharityListHelper is a Static utility to perform Deserialization operations
	 * 
	 */

	private CharityListHelper() {
		// Private constructor to restrict initialization of CharityListHelper class
	}

	public static ArrayList<String> getDescriptionList(String response)
			throws JsonMappingException, JsonProcessingException {
		ArrayList<String> charities = new ArrayList<String>();
		if (response != null && !(response.isEmpty())) {

			// DeSerializing JSON response to respective POJO class
			ObjectMapper mapper = new ObjectMapper();
			Pojo.CharitiesList[] objArray = mapper.readValue(response, Pojo.CharitiesList[].class);
			for (int i = 0; i < objArray.length; i++) {
				if(objArray[i].getDescription() != null) {
					charities.add(objArray[i].getDescription());
				}
				
			}

		}

		return charities;

	}
}
