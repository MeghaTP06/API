package EndToEndScenario;

import GenericLibrary.BaseClassForRequestSpecificationBuilder;
import GenericLibrary.DatabaseUtility;
import GenericLibrary.EndPointsLibrary;
import GenericLibrary.JavaUtility;
import GenericLibrary.RestAssuredLibrary;
import PojoLibrary.PojoClass;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectAndVerifyInDataBase extends BaseClassForRequestSpecificationBuilder
{
	@Test
	public void CreateProjectAndVerifyInDataBaseTest() throws Throwable
	{
//		DatabaseUtility dlib=new DatabaseUtility();
//	RestAssuredLibrary rlib=new RestAssuredLibrary();
//	JavaUtility jLib=new JavaUtility();
	PojoClass plib=new PojoClass("Megha", "HRA"+jLib.GetRandomNumber(), "created", 5);
	System.out.println(plib);
	Response r=given().spec(requestSpec)
			.body(plib)
			.when()
			.post(EndPointsLibrary.CreateProject);
	
	String expectedData=rLib.getJsonData(r, "projectId");
			System.out.println(expectedData);
			
			String query="select * from project;";
			String actualData=dLib.readDataFromDBAndValidate(query, 1, expectedData);
			System.out.println(actualData);
			
			Assert.assertEquals(expectedData, actualData);
}
}
