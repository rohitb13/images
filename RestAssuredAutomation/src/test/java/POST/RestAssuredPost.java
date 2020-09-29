package POST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RestAssuredPost {
	
	@Test
	void postEnumDetails()
	{
		// Base URL
		RestAssured.baseURI = "https://udd.kpit.com/UDD/api/enumeration?profile=TOOLTIP";
		
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
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
		
		//Add Header 
		httpRequest.header("Content-Type","application/json");
		
		//Add JSON to body
		httpRequest.body(((JSONObject) requestParams));
		
		//Post Request
		Response response = httpRequest.request(Method.POST,"");
		
		// Get ResponseBody 
		String responseBody = response.getBody().asString();

		// Print ResponseBody
		System.out.println("Response body is :" + responseBody);
		
		Assert.assertEquals(responseBody.contains("U"), true);

		// validation status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		
		
		
	}

}
