package RequestUsingCRUDOperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.BaseClassForRequestSpecificationBuilder;
import GenericLibrary.EndPointsLibrary;
import GenericLibrary.JavaUtility;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Post extends BaseClassForRequestSpecificationBuilder
{
	@Test

	public void addProject() throws Throwable 
	{
		/*create json body using json simple*/
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Megha");
		jobj.put("projectName", "HRA"+jLib.GetRandomNumber());
		jobj.put("status", "created");
		jobj.put("teamsize", 5);
		
		/*prerequest for the script*/
		 given()
		 .spec(requestSpec)
		 .body(jobj)
		 
		 //ACTION
		 .when()
             .post(EndPointsLibrary.CreateProject)
		//validation
        .then()

		.assertThat().statusCode(201)
		.assertThat().statusLine("HTTP/1.1 201 ")
		.log().all();	
	}
}

