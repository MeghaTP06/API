package Authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class BasicPremitiveAuth 
{
	@Test
	public void BasicPremitiveAuthTest()
	{
		baseURI="http://localhost";
		port=8084;
		
	given()
	.auth().preemptive().basic("rmgyantra", "rmgy@9999")
	
	.when()
	.get("/login")
	
	.then()
	.assertThat().log().all();
	}
}
