package Parameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PathParameter 
{
	@Test
	public void PathParameterTest()
	{
//	Response r=given()	
//	
//	.baseUri("http://localhost")
//	.basePath("api/users")
//	.pathParam("userid", 2)
//	
//	.when()
//	.get("/{userid}");
		
		String proId="TY_PROJ_001";
		given().pathParam("projectId", proId)
		
		.when()
		.get("http://localhost:8084/projects/{projectId}")
		
		.then()
		.log()
		.all();
	}
}
