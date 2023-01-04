package CRUDWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteProjectTest 
{	
@Test
	public void deleteProjectTest() 
	{
		when()
		  .delete("http://localhost:8084/projects/TY_PROJ_1003")
			
		.then()
		
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(204)
		.assertThat().statusLine("HTTP/1.1 204 ")
		.log().all();
		}
}


