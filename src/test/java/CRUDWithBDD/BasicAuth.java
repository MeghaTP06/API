package CRUDWithBDD;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import net.bytebuddy.NamingStrategy.SuffixingRandom.BaseNameResolver.ForGivenType;

public class BasicAuth 
{
	@Test
	public void BasicAuthTest()
	{
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.assertThat().statusCode(202).log().all();
		
	}

}
