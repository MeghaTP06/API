package CRUDWithBDD;

import static io.restassured.RestAssured.given;

import javax.sound.sampled.Port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;

public class AddProjectwithoutStatus 
{
	@Test

	public void addProject() {
		/*create json body using json simple*/
		JavaUtility jlib = new JavaUtility();
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Megha");
		jobj.put("projectName", "HRA"+jlib.GetRandomNumber());
		jobj.put("teamsize", 5);
		
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
