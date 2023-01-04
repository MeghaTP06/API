package CRUDWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;

public class AddProjectWithoutEndurl {
/*MethodNotAllowed 405*/
	@Test

	public void addProject() {
		/*create json body using json simple*/
		JavaUtility jlib = new JavaUtility();
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Megha");
		jobj.put("projectName", "HRAMA"+jlib.GetRandomNumber());
		jobj.put("status", "created");
		jobj.put("teamsize", 10);
		
		/*prerequest for the script*/
		 given()
		 .body(jobj)
		 .contentType(ContentType.JSON)
		 
		 //ACTION
		 .when()
         .post("http://localhost:8084/")
		
         //validation
        .then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(405)
		.assertThat().statusLine("HTTP/1.1 405 ")
		.log().all();
}
	}

