package CRUDWithBDD;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParameter 
{
	@Test
	public void QueryParameterTest()
	{
		given()
		.queryParam("page",2)
		.when()
		.get("https://reqres.in/api/users")
		.then().log().all();
		
	}

}
