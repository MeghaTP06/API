package Authentication;

import org.testng.annotations.Test;

import GenericLibrary.JavaUtility;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class oauth2o 
{
	@Test
	public void oauthTest()
	{
		Response response = given()
			.formParam("client_id", "ALP")
			.formParam("client_secret", "3fbb8ca77134979368780bc08e941456")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "https://example.com")
			.formParam("code", "a_code")
	
			.when()
			.post("http://coop.apps.symfonycasts.com/token");
			 System.out.println(response);
	 
			 String token = response.jsonPath().get("access_token");
			 System.out.println(token);
	 
	 
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID",4161)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		//.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		//.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		//.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/toiletseat-down")
		//.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
		
		
		.then()
		.log().all();	
	}
}
