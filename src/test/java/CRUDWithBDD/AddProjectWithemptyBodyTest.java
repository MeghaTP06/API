package CRUDWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;

public class AddProjectWithemptyBodyTest {
	@Test

	public void addProject() {
		
		/*create json body using json simple*/
		JSONObject jobj = new JSONObject();
	
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
		.assertThat().statusCode(409)
		.assertThat().statusLine("HTTP/1.1 409 ")
		.assertThat().and()
		.log().all();
		

}}

