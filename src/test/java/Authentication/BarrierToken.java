package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BarrierToken 
{
	@Test
	public void BarrierTokenTest()
	{
		baseURI="https://api.github.com";
		JSONObject jobj=new JSONObject();
		jobj.put("name", "onlineRestAssured-2.00");
		
		given()
		.auth()
		.oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then()
		.assertThat().log().all();
	}

}
