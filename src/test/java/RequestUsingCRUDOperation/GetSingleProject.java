package RequestUsingCRUDOperation;

import org.testng.annotations.Test;

import GenericLibrary.BaseClassForRequestSpecificationBuilder;
import GenericLibrary.EndPointsLibrary;
import GenericLibrary.ExcelUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProject extends BaseClassForRequestSpecificationBuilder 
{
	@Test
	public void GetSingleProjectTest() throws Throwable
	{
		//ExcelUtility eLib=new ExcelUtility();
		String proId=eLib.readDataFromExcel("Sheet1", 1, 1);
		System.out.println(proId);
		
		given()
		.spec(requestSpec)
		.pathParam("Id", proId)
		
		.when()
		.get(EndPointsLibrary.GetSingleProject+"{Id}")
		
		.then()
		.assertThat().and()
		
		.log().all();
	}
}
