package RequestUsingCRUDOperation;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.BaseClassForRequestSpecificationBuilder;
import GenericLibrary.EndPointsLibrary;

public class putProject extends BaseClassForRequestSpecificationBuilder 
{
	@Test
	public void putProjectTest() throws Throwable
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Megha");
		jobj.put("projectName", "HRA"+jLib.GetRandomNumber());
		jobj.put("status", "created");
		jobj.put("teamsize", 6);
		String proId=eLib.readDataFromExcel("Sheet1", 1, 1);
		System.out.println(proId);
		
		/*prerequest for the script*/
		 given()
		 .spec(requestSpec)
		 .body(jobj)
		 .pathParam("Id", proId)
		 
		 //ACTION
		 .when()
             .put(EndPointsLibrary.UpdateProject+"{Id}")
		//validation
        .then()

		
		.log().all();
	}
}
