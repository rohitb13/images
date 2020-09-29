import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.files;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://reqres.in/";
		
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(files.body()).when().post("/api/users")
		.then().assertThat().statusCode(201).body("name", equalTo("morpheus")).header("Server", "cloudflare").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String name=js.getString("name");
		System.out.println(name);
	}

}

