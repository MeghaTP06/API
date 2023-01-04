package Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HeaderValidationTest 
{
	@Test
	public void validation()
	{
		baseURI="http://localhost";
		port=8084;
		String expecContentType="application/json";
		String expectedVary="Access-Control-Request-Headers";
		String expectedPragma="no-cache";
    Response response = when().get("projects");
   String actaulContentType = response.getContentType();
   String actaulVary = response.getHeader("vary");
   String actualPragma = response.getHeader("Pragma");
   response.then().log().all();
   Assert.assertEquals(expecContentType, actaulContentType);
   Assert.assertEquals(expectedVary, actaulVary);
   Assert.assertEquals(actualPragma, expectedPragma);
	}

}