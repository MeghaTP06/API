package DataDriven;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericLibrary.ExcelUtility;
import GenericLibrary.JavaUtility;

import io.restassured.http.ContentType;

public class CreateProjectUsingDataProviderExcel 
{
	@Test(dataProvider="readDataFromExcel")
	public void addProjectTest(String createdBy, String projectName,String status,String teamSize)
	{
		PojoLibrary.pojoclassc pcc=new PojoLibrary.pojoclassc(createdBy, projectName, status, teamSize);
		
		 given()
		 .body(pcc)
		  .contentType(ContentType.JSON)
		 
		 
		 //ACTION
		 .when()
            .post("http://localhost:8084/addProject")
            
		//validation
       .then()

		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
	}
	
	@DataProvider
	public Object[][] readDataFromExcel() throws Throwable
	{
		ExcelUtility elib=new ExcelUtility();
		Object[][] value=elib.readMultipleData("Sheet1");
		return value;
	}
}
