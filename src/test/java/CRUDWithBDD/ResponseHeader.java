package CRUDWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResponseHeader 
{
	@Test
	public void ResponseHeaderTest()
	{
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
             .post("http://localhost:8084/addProject");
             
             
           //validation
             //.then()
             String expectedContentType="application/json";
    		 String expectedheader="Access-Control-Request-Headers";
    		 String expectedPragma="no-cache";
    		 
//    		 Response r//=//.when().get("projects");
//    		 String actualContentType=r.getContentType();
//    		 String actualheader=r.getHeader("vary");
//    		 String actualPragma=r.getHeader("Pragma");
//    		 r.then().log().all();
	}

}
