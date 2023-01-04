package RequestUsingCRUDOperation;

import org.testng.annotations.Test;

import GenericLibrary.BaseClassForRequestSpecificationBuilder;
import GenericLibrary.EndPointsLibrary;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetAllProject extends BaseClassForRequestSpecificationBuilder
{
	@Test

	public void getProject() 
	{
		given()
		.spec(requestSpec)
		
		 .when()
		 .get(EndPointsLibrary.GetAllProject)
		 .then()
			
			
			.assertThat().statusCode(200)
			.assertThat().statusLine("HTTP/1.1 200 ")
			.log().all();			
}
}

