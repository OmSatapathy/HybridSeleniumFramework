package apiTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class getApiTest {

	@Test
	public void getApi() {

		String res = RestAssured.given().contentType("application/json").when()
				.get("https://api.restful-api.dev/objects").then().extract().response().asPrettyString();
		JsonPath jpath = new JsonPath(res);
		System.out.println(jpath.getString("name"));

	}

}
