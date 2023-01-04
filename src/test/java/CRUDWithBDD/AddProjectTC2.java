package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AddProjectTC2 
{
	@Test

	public void addProject() 
	{
		/*create json body using json simple*/
		JavaUtility jlib = new JavaUtility();
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Megha");
		jobj.put("projectName", "HRA"+jlib.GetRandomNumber());
		jobj.put("status", "");
		jobj.put("teamsize", "");
		
		/*prerequest for the script*/
		 given()
		 .body(jobj)
		  .contentType(ContentType.JSON)
		 
		 
		 //ACTION
		 .when()
             .post("http://localhost:8084/addProject")
             
		//validation
        .then()

		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.assertThat().statusLine("HTTP/1.1 201 ")
		.log().all();
			
}
}
