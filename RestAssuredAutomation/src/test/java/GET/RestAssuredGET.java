package GET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RestAssuredGET {

	@Test
	void getDetails() {
		// Base URL
		RestAssured.baseURI = "https://udd.kpit.com/UDD/api/workspaces/elementType";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Response Object
		Response response = httpRequest.request(Method.GET, "/enumeration?profile=FULL&id=667");

		// Get ResponseBody 
		String responseBody = response.getBody().asString();

		// Print ResponseBody
		System.out.println("Response body is :" + responseBody);

		// validation status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(201, statusCode);

		// validation header
		String contentType = response.header("Content-Type");
		Assert.assertEquals("application/json", contentType);

		// Get all headers
		Headers allheaders = response.headers();
		for (Header header : allheaders) {
			System.out.println(header.getName() + " : " + header.getValue());
		}

		// to get body data create jsonpath object
		JsonPath jsonpath = response.jsonPath();

		// Get body values using there key
		//System.out.println(""+jsonpath.get());

	}

}
