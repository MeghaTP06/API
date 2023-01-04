package CRUDWithBDD;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Snippets 
{
	@Test

	public void SnippetsTest() 
	{
		Response r=given()
				.baseUri("https://localhost:8084")
				.basePath("api/users")
				.pathParam("userid", 2)
				.when()
				.get("/{userid}");
//		String projId="TY_PROJ_805";
//		given().pathParam("projectID", projId);
//		when().get("http://localhost:8084/projects/:{projectID}")
//		
//		.then()
//		.assertThat().statusCode(200).log().all();
}
}