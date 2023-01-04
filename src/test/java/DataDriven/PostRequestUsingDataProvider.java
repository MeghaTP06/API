package DataDriven;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

public class PostRequestUsingDataProvider 
{
	@Test(dataProvider="Test")
	public void addProjectTest(String createdBy, String projectName,String status,int teamSize)
	{
		PojoClass pc=new PojoClass(createdBy, projectName, status, teamSize);
		
		 given()
		 .body(pc)
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
	public Object[][] Test()
	{
		Object[][] obj=new Object[2][4];
		obj[0][0]="Megha";
		obj[0][1]="NAP257";
		obj[0][2]="ongoing";
		obj[0][3]=5;
		
		obj[1][0]="Megha";
		obj[1][1]="NAP457";
		obj[1][2]="created";
		obj[1][3]=5;
		return obj;
		}
	}


