package DifferentWaysToPost;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

public class CreateProjectUsingPojoClass 
{
	@Test
	public void test()
	{
		PojoClass pc=new PojoClass("Megha", "CAP", "ongoing", 10);
		
		 given()
		 .body(pc)
		  .contentType(ContentType.JSON)
		 
		 
		 //ACTION
		 .when()
             .post("http://localhost:8084/addProject")
             
		//validation
        .then()

		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
	}

}
