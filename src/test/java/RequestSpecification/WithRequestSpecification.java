package RequestSpecification;

import static io.restassured.RestAssured.*;

import org.junit.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class WithRequestSpecification 
{
	RequestSpecification requestSpecification;
	
	@BeforeClass
	public void setUpRequestSpecification()
	{
		requestSpecification=RestAssured.given()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/booking");
	}
	@Test
	public void getAllBookings()
	{
		RestAssured
		.given()
		.spec(requestSpecification)
		
		.when()
		
		.then()
		.statusLine("HTTP/1.1 200 OK");
	}
	@Test
	public void getBookingDetailsWithInvalidFirstName()
	{
		RestAssured
		.given(requestSpecification)
		
		.param("firstName", "Ana")
		
		.when()
		
		.then()
		
		.statusLine("HTTP/1.1 200 Ok");
	}
}
