package CRUDWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllProjects 
{
	@Test

	public void getProject() 
	{
		 when()
		 .get("http://localhost:8084/projects")
		 .then()
			
			.assertThat().contentType(ContentType.JSON)
			.assertThat().statusCode(200)
			.assertThat().statusLine("HTTP/1.1 200 ")
			.log().all();			
}
}

