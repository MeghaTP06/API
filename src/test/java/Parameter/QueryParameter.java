package Parameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameter 
{
	@Test
	public void QuerrParameterTest()
	{
		given()
		.queryParam("page",2)
		
		.when()
		.get("https://reqres.in/api/users")
		
		.then()
		.log()
		.all();
	}

}
