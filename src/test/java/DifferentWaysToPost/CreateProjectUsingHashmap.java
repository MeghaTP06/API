package DifferentWaysToPost;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingHashmap 
{
	@Test
	public void test()
	{
		HashMap hp=new HashMap();
		hp.put("createdBy", "Megha");
		hp.put("projectName", "PAS");
		hp.put("status", "ongoing");
		hp.put("teamSize", 5);
		
		 given()
		 .body(hp)
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
