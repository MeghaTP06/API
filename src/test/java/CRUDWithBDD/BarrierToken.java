package CRUDWithBDD;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BarrierToken 
{
	@Test
	public void BarrierTokenTest()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.assertThat().statusCode(200).log().all();
	}
}
