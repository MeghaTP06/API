package Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidation 
{
	@Test
	public void test()
	{
		baseURI="http://localhost";
		port=8084;
		
		when()
		.get("/projects")
		
		.then()
		.assertThat().time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS)
		.log().all();
	}

}
