package Validation;

import static io.restassured.RestAssured.*;

import java.awt.List;
import java.util.Iterator;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetProjectDynamic 
{
	@Test
	public void getTest()
	{
				baseURI="http://localhost";
				port=8084;
				String expectpId="TY_PROJ_1603";
				 Response res = when().get("projects");
				 java.util.List<String> actulPid = res.jsonPath().get("projectId");
				 Boolean flag= false;
				 for (String aID : actulPid) 
				 {
					 if(aID.equalsIgnoreCase(expectpId)) 
					 {
						 System.out.println("project id is found");
						
					 }
				}
				 flag=true;
				 Assert.assertTrue(flag);
			}
}
