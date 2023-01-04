package CRUDWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChaining 
{
	@Test
	public void RequestChaining()
	{
		JavaUtility jlib = new JavaUtility();
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Megha");
		jobj.put("projectName", "HRA"+jlib.GetRandomNumber());
		jobj.put("status", "ongoing");
		jobj.put("teamsize", "5");
		
		/*prerequest for the script*/
		 Response response=given()
		 .body(jobj)
		  .contentType(ContentType.JSON)
		 
		 
		 //ACTION
		 .when()
             .post("http://localhost:8084/addProject");
		 String projID=response.jsonPath().getString("projectId");
		 given()
		 .pathParam("projectId", projID)
		 .when()
		 .get("projects/{projectId}")
		 .then().log().all();
	}

}
