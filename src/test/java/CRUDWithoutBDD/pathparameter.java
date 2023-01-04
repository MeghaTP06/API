package CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class pathparameter 
{
	@Test
	public void pathparameterTest()
	{
	/*create json body using json simple*/
	JavaUtility jlib = new JavaUtility();
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "Megha");
	jobj.put("projectName", "HRA"+jlib.GetRandomNumber());
	jobj.put("status", "ongoing");
	jobj.put("teamsize", "5");
	
	RequestSpecification rs=RestAssured.given();
	rs.body(jobj);
	rs.contentType(ContentType.JSON);
	
	RequestSpecification url=rs.baseUri("http://localhost:8084");
	rs.pathParam("resoursepath", "addProject");
	Response r=rs.post("/{resoursepath}");
	
}
}
