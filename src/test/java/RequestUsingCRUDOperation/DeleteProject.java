package RequestUsingCRUDOperation;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import GenericLibrary.BaseClassForRequestSpecificationBuilder;
import GenericLibrary.EndPointsLibrary;

public class DeleteProject extends BaseClassForRequestSpecificationBuilder 
{
	@Test
	public void DeleteProjectTest() throws Throwable
	{
		String proId=eLib.readDataFromExcel("Sheet1", 1, 1);
		System.out.println(proId);
		
		given()
		.spec(requestSpec)
		.pathParam("Id", proId)
		
		.when()
		.delete(EndPointsLibrary.GetSingleProject+"{Id}")
		
		.then()
		.assertThat().and()
		
		.log().all();
	}
}
