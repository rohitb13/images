package POST;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;

	public class PostData {
		
		@Test
		void postEnumDetails()
		{
			// Base URL
			RestAssured.baseURI = "https://udd.kpit.com/UDD/api/enumeration?profile=TOOLTIP";
			
			//Request Object
			//RequestSpecification httpRequest = RestAssured.given();
			
			//JSONObject requestParams = new JSONObject();
			
			List<Map<String,Object>> value = new ArrayList<>();
			
			Map<String,Object> values = new HashMap<>();
			
			values.put("value", 1);
			values.put("description", "ENUMERATION04");
			values.put("text", "ENUMERATION04");
			
			value.add(values);
			
			List<Map<String,Object>> bitvalue = new ArrayList<>();
			
			Map<String,Object> bitvalues = new HashMap<>();
			
			bitvalues.put(null, null);
			
			bitvalue.add(bitvalues);
			
			
			values.put("value", 1);
			
			Map<String,Object> requestParams = new HashMap<>();
			
			requestParams.put("shortName", "ENUMERATION04");
			requestParams.put("description", "ENUMERATION04");
			requestParams.put("values", value );
			requestParams.put("longName", "ENUMERATION04");
			requestParams.put("autosarPath", "/FCADataDefinition/AppDatatypes/ADTSENUMERATION04");
			requestParams.put("bitValues", bitvalue);
			requestParams.put("bitStatus", "N");
			requestParams.put("changeSetId", "70691");
			requestParams.put("categoryId", "AS");
			requestParams.put("workspaceId", "563");
			
			Response response = given().
			contentType("application/json").
			accept("applicaiton/json").
			body(requestParams).when().
			post("https://udd.kpit.com/UDD/api/enumeration?profile=TOOLTIP").then().statusCode(200).
			contentType("application/json").extract().response();	
			String id = response.jsonPath().getString("id");
			assertNotNull(id);
		}

	}



