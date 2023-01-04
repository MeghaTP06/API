package Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class getAllProjectStaticValidationTest 
{
	@Test
	public void getTest()
	{
		baseURI="http://localhost";
		port=8084;
		
		Response r=when().get("/projects");
		String actualProjectName=r.jsonPath().getString("[1].projectName");
		Assert.assertEquals(actualProjectName, "proName4642");
	}

}
