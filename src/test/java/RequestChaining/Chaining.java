package RequestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import GenericLibrary.JavaUtility;
import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Chaining 
{
	@Test
	public void ChainingTest()
	{
	baseURI="http://localhost";
	port=8084;
	
	PojoClass pc=new PojoClass("Megha", "OPP"+new JavaUtility().GetRandomNumber(), "ongoing", 9);
	Response response=given()
			.body(pc)
			.contentType(ContentType.JSON)
	
	.when()
	.post("/addProject");
	String pid=response.jsonPath().get("projectId");
	//System.out.println(pid);
	
	given()
	
	.pathParam("projectId", pid)
	
	.when()
	.get("/projects/{projectId}")
	
	.then()
	.log()
	.all();
	}
}
